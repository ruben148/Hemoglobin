package com.rbbr.hemoglobin.service.impl;

import com.rbbr.hemoglobin.dto.DoctorDTO;
import com.rbbr.hemoglobin.dto.DonorCreateDTO;
import com.rbbr.hemoglobin.dto.DonorDTO;
import com.rbbr.hemoglobin.entity.Donor;
import com.rbbr.hemoglobin.mapper.DonorMapper;
import com.rbbr.hemoglobin.repo.DonorRepo;
import com.rbbr.hemoglobin.service.DonorService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DonorServiceImpl implements DonorService {
    @Autowired
    DonorRepo donorRepo;
    @Autowired
    DonorMapper donorMapper;

    @Override
    public DonorDTO register(DonorCreateDTO donorCreateDTO) {
        Donor donor = donorMapper.toDonor(donorCreateDTO);
        //TODO email and phone number check
        return donorMapper.toDonorDTO(donorRepo.save(donor));
    }

    @Override
    public DonorDTO findById(Long id) {
        Optional<Donor> donor = donorRepo.findById(id);
        return donor.map(value -> donorMapper.toDonorDTO(value)).orElse(null);
    }

    @Override
    public DonorDTO update(DonorDTO donorDTO) {
        Donor donorInitial = donorRepo.findById(donorDTO.getId()).orElse(null);
        Donor donor = donorMapper.toDonor(donorInitial, donorDTO);
        Donor donorModified = donorRepo.save(donor);
        return donorMapper.toDonorDTO(donorModified);
    }

    @Override
    public void delete(Long id) {
        donorRepo.deleteById(id);
    }
}
