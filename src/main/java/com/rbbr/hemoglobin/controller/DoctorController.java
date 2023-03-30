package com.rbbr.hemoglobin.controller;

import com.rbbr.hemoglobin.dto.DoctorDTO;
import com.rbbr.hemoglobin.dto.DonorDTO;
import com.rbbr.hemoglobin.dto.UserLoginDTO;
import com.rbbr.hemoglobin.service.DoctorService;
import com.rbbr.hemoglobin.service.DonorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = {"/", ""})
    public String getUserLoginPage(HttpSession session) {

        String userType = (String) session.getAttribute("userType");
        if (userType != null && userType.equals("doctor"))
            return "redirect:/doctor/home";

        return "login.html";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userType");
        return "redirect:/doctor/";
    }

    @GetMapping("/home")
    public String getHomePage(HttpSession session){

        String userType = (String) session.getAttribute("userType");
        if (userType == null || !userType.equals("doctor"))
            return "redirect:/doctor/";
        return "home.html";
    }

    @PostMapping(value = {"/", ""})
    public String login(@ModelAttribute("userLoginDTO") UserLoginDTO userLoginDTO, HttpServletRequest request, Model model) {
        DoctorDTO doctorDTO = doctorService.login(userLoginDTO.getUsername(), userLoginDTO.getPassword(), request);
        if (doctorDTO != null)
            return "redirect:/doctor/home";
        model.addAttribute("error", true);
        return "login.html";
    }
}
