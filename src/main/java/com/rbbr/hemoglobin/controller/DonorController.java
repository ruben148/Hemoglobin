package com.rbbr.hemoglobin.controller;

import com.rbbr.hemoglobin.dto.DoctorDTO;
import com.rbbr.hemoglobin.dto.DonorCreateDTO;
import com.rbbr.hemoglobin.dto.DonorDTO;
import com.rbbr.hemoglobin.dto.UserLoginDTO;
import com.rbbr.hemoglobin.entity.Donor;
import com.rbbr.hemoglobin.service.DonorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Controller
@RequestMapping("")
public class DonorController {
    @Autowired
    private DonorService donorService;

    @GetMapping(value = {"/", ""})
    public String getUserLoginPage(HttpSession session) {

        String userType = (String) session.getAttribute("userType");
        if (userType != null && userType.equals("donor"))
            return "redirect:/home";

        return "login_r.html";
    }

    @PostMapping(value = {"/", ""})
    public String login(@ModelAttribute("userLoginDTO") UserLoginDTO userLoginDTO, HttpServletRequest request, Model model) {
        DonorDTO donorDTO = donorService.login(userLoginDTO.getUsername(), userLoginDTO.getPassword(), request);
        if (donorDTO != null)
            return "redirect:/home";
        model.addAttribute("error", true);
        return "login_r.html";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userType");
        return "redirect:/";
    }

    @GetMapping("/home")
    public String getHomePage(HttpSession session){

        String userType = (String) session.getAttribute("userType");

        if (userType == null || !userType.equals("donor"))
            return "redirect:/";
        return "home.html";
    }

    @GetMapping("/register")
    public String getRegistrationPage(HttpSession session){

        String userType = (String) session.getAttribute("userType");

        if (userType != null)
            return "redirect:/";
        return "register.html";
    }

    @PostMapping(value = {"/register"})
    public String register(@ModelAttribute("userLoginDTO") DonorCreateDTO donorCreateDTO, Model model) {
        DonorDTO donorDTO = donorService.register(donorCreateDTO);
        //TODO email and phone number check in register method
        if (donorDTO != null)
            return "redirect:/";
        model.addAttribute("error", true);
        return "register.html";
    }



    @GetMapping("/edit/{id}")
    public String editDonor(@PathVariable Long id, Model model, HttpSession session) {

        String userType = (String) session.getAttribute("userType");
        if (userType == null || !userType.equals("admin"))
            return "redirect:/admin/";

        DoctorDTO doctor = doctorService.findById(id);
        if(doctor == null)
            return "redirect:/admin/dashboard";
        model.addAttribute("doctor", doctor);
        return "edit_doctor";
    }

    @PostMapping("/edit")
    public String editDonor(HttpSession session, @ModelAttribute("doctor") DoctorDTO doctor,
                             RedirectAttributes redirectAttributes){

        String userType = (String) session.getAttribute("userType");
        if (userType == null || !userType.equals("admin"))
            return "redirect:/admin/";

        doctorService.update(doctor);

        redirectAttributes.addFlashAttribute("message", "Doctor information updated successfully!");
        return "redirect:/admin/dashboard";
    }

    @RequestMapping("/delete-doctor/{id}")
    public String deleteDoctor(HttpSession session, @PathVariable Long id) {
        String userType = (String) session.getAttribute("userType");
        if (userType == null || !userType.equals("admin"))
            return "redirect:/admin/";
        doctorService.delete(id);
        return "redirect:/admin/dashboard";
    }

}
