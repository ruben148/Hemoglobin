package com.rbbr.hemoglobin.service.impl;

import com.rbbr.hemoglobin.dto.AdminDTO;
import com.rbbr.hemoglobin.entity.Admin;
import com.rbbr.hemoglobin.mapper.AdminMapper;
import com.rbbr.hemoglobin.repo.AdminRepo;
import com.rbbr.hemoglobin.service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepo adminRepo;
    @Autowired
    AdminMapper adminMapper;
}
