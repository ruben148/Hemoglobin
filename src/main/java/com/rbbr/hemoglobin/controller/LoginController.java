package com.rbbr.hemoglobin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @GetMapping("")
    public String helloDonor() {
        return "Hello Donor!";
    }

    @GetMapping("/admin")
    public String helloAdmin() {
        return "Hello Admin!";
    }

    @GetMapping("/doctor")
    public String helloDoctor() {
        return "Hello Doctor!";
    }
}
