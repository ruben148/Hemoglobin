package com.rbbr.hemoglobin.controller;

import com.rbbr.hemoglobin.dto.TokenDTO;
import com.rbbr.hemoglobin.dto.UserLoginDTO;
import com.rbbr.hemoglobin.entity.*;
import com.rbbr.hemoglobin.repo.TokenRepo;
import com.rbbr.hemoglobin.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody UserLoginDTO inputUser, HttpServletResponse response) {
        System.out.println("Trying to login user with username: " + inputUser.getUsername() + " and password: " + inputUser.getPassword() + "...");
        TokenDTO savedToken = userService.authenticateUser(inputUser);
        if (savedToken!=null) {
            return ResponseEntity.ok(savedToken);
        } else {
            System.out.println("Unauthorized user");
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody String token) {
        System.out.println("Trying to logout user with token: " + token + "...");
        userService.logout(token);
        return ResponseEntity.ok("Logged out successfully");
    }
}
