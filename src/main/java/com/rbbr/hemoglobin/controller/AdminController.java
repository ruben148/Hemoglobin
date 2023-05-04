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

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private DoctorService doctorService;


}
