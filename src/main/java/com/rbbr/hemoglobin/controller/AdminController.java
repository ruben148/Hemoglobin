package com.rbbr.hemoglobin.controller;

import com.rbbr.hemoglobin.dto.AdminDTO;
import com.rbbr.hemoglobin.dto.DoctorDTO;
import com.rbbr.hemoglobin.dto.UserLoginDTO;
import com.rbbr.hemoglobin.service.AdminService;
import com.rbbr.hemoglobin.service.DoctorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = {"/", ""})
    public String getUserLoginPage(HttpSession session) {

        String userType = (String) session.getAttribute("userType");
        if (userType != null && userType.equals("admin"))
            return "redirect:/admin/dashboard";

        return "login.html";
    }

    @PostMapping(value = {"/", ""})
    public String login(@ModelAttribute("userLoginDTO") UserLoginDTO userLoginDTO, HttpServletRequest request, Model model) {
        AdminDTO adminDTO = adminService.login(userLoginDTO.getUsername(), userLoginDTO.getPassword(), request);
        if (adminDTO != null)
            return "redirect:/admin/dashboard";
        model.addAttribute("error", true);
        return "login.html";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userType");
        return "redirect:/admin";
    }

    @GetMapping("/dashboard")
    public String getHomePage(HttpSession session){

        String userType = (String) session.getAttribute("userType");
        if (userType == null || !userType.equals("admin"))
            return "redirect:/admin/";
        return "admin_dashboard.html";
    }

    @GetMapping("/edit-doctor/{id}")
    public String editDoctor(@PathVariable Long id, Model model, HttpSession session) {

        String userType = (String) session.getAttribute("userType");
        if (userType == null || !userType.equals("admin"))
            return "redirect:/admin/";

        DoctorDTO doctor = doctorService.findById(id);
        if(doctor == null)
            return "redirect:/admin/dashboard";
        model.addAttribute("doctor", doctor);
        return "edit_doctor";
    }

    @PostMapping("/edit-doctor")
    public String editDoctor(HttpSession session, @ModelAttribute("doctor") DoctorDTO doctor,
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
