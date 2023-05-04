package com.rbbr.hemoglobin.service;

import com.rbbr.hemoglobin.dto.DoctorDTO;
import com.rbbr.hemoglobin.dto.DonorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface DoctorService {
    DoctorDTO findById(Long id);
    Page<DoctorDTO> findAll(String search, int page);
    DoctorDTO update(DoctorDTO doctorDTO);
    void delete(Long id);
}
