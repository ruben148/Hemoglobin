package com.rbbr.hemoglobin.service.impl;

import com.rbbr.hemoglobin.dto.DonorCreateDTO;
import com.rbbr.hemoglobin.dto.DonorDTO;
import com.rbbr.hemoglobin.entity.Donor;
import com.rbbr.hemoglobin.mapper.DonorMapper;
import com.rbbr.hemoglobin.repo.DonorRepo;
import com.rbbr.hemoglobin.service.DonorService;
import com.rbbr.hemoglobin.util.SessionStuff;
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
    @Autowired
    SessionStuff sessionStuff;

    @Override
    public DonorDTO login(String username, String password, HttpServletRequest request) {
        Optional<Donor> donor = donorRepo.findByUsernameAndPassword(username, password);
        if(donor.isPresent()) {
            sessionStuff.setSessionUserType("donor", request);
            return donorMapper.toDonorDTO(donor.get());
        }
        else
            return null;
    }

    @Override
    public DonorDTO register(DonorCreateDTO donorCreateDTO) {
        Donor donor = donorMapper.toDonor(donorCreateDTO);
        //TODO email and phone number check
        return donorMapper.toDonorDTO(donorRepo.save(donor));
    }
}
