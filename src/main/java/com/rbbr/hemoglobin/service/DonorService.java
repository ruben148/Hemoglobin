package com.rbbr.hemoglobin.service;

import com.rbbr.hemoglobin.dto.DonorCreateDTO;
import com.rbbr.hemoglobin.dto.DonorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface DonorService {
    DonorDTO login(String username, String password, HttpServletRequest request);
    DonorDTO register(DonorCreateDTO donorCreateDTO);
}
