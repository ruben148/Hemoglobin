package com.rbbr.hemoglobin.service;

import com.rbbr.hemoglobin.dto.DoctorDTO;
import com.rbbr.hemoglobin.dto.DonorCreateDTO;
import com.rbbr.hemoglobin.dto.DonorDTO;
import com.rbbr.hemoglobin.entity.Donor;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface DonorService {
    DonorDTO register(DonorCreateDTO donorCreateDTO);
    DonorDTO findById(Long id);
    DonorDTO update(DonorDTO donor);
    void delete(Long id);
}
