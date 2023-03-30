package com.rbbr.hemoglobin.service.impl;

import com.rbbr.hemoglobin.dto.AdminDTO;
import com.rbbr.hemoglobin.entity.Admin;
import com.rbbr.hemoglobin.entity.Donor;
import com.rbbr.hemoglobin.mapper.AdminMapper;
import com.rbbr.hemoglobin.repo.AdminRepo;
import com.rbbr.hemoglobin.service.AdminService;
import com.rbbr.hemoglobin.util.SessionStuff;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepo adminRepo;
    @Autowired
    SessionStuff sessionStuff;
    @Autowired
    AdminMapper adminMapper;

    @Override
    public AdminDTO login(String username, String password, HttpServletRequest request) {
        Optional<Admin> admin = adminRepo.findByUsernameAndPassword(username, password);
        if(admin.isPresent()) {
            sessionStuff.setSessionUserType("admin", request);
            return adminMapper.toAdminDTO(admin.get());
        }
        else
            return null;
    }
}
