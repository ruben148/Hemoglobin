package com.rbbr.hemoglobin.service;

import com.rbbr.hemoglobin.dto.DoctorDTO;
import com.rbbr.hemoglobin.dto.DonorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public interface DoctorService {
    DoctorDTO findById(Long id);
    DoctorDTO login(String username, String password, HttpServletRequest request);
    DoctorDTO update(DoctorDTO doctorDTO);
    void delete(Long id);
}
