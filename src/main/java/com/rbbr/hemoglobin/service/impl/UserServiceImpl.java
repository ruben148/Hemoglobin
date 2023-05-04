package com.rbbr.hemoglobin.service.impl;

import com.rbbr.hemoglobin.dto.TokenDTO;
import com.rbbr.hemoglobin.dto.UserLoginDTO;
import com.rbbr.hemoglobin.entity.*;
import com.rbbr.hemoglobin.repo.AdminRepo;
import com.rbbr.hemoglobin.repo.DoctorRepo;
import com.rbbr.hemoglobin.repo.DonorRepo;
import com.rbbr.hemoglobin.repo.TokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements com.rbbr.hemoglobin.service.UserService{
    @Autowired
    private DonorRepo donorRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private TokenRepo tokenRepo;

    public TokenDTO authenticateUser(UserLoginDTO inputUser) {
        Optional<Donor> donor = donorRepo.findByUsername(inputUser.getUsername());
        if (donor.isPresent() && donor.get().getPassword().equals(inputUser.getPassword())) {
            Token token = new Token(java.time.LocalDateTime.now().plusHours(3), donor.get(), "DONOR");
            tokenRepo.save(token);
            return new TokenDTO(token);
        }

        Optional<Doctor> doctor = doctorRepo.findByUsername(inputUser.getUsername());
        if (doctor.isPresent() && doctor.get().getPassword().equals(inputUser.getPassword())) {
            Token token = new Token(java.time.LocalDateTime.now().plusHours(3), doctor.get(), "DOCTOR");
            tokenRepo.save(token);
            return new TokenDTO(token);
        }

        Optional<Admin> admin = adminRepo.findByUsername(inputUser.getUsername());
        if (admin.isPresent() && admin.get().getPassword().equals(inputUser.getPassword())) {
            Token token = new Token(java.time.LocalDateTime.now().plusHours(3), admin.get(), "ADMIN");
            tokenRepo.save(token);
            return new TokenDTO(token);
        }

        return null;
    }
    public void logout(String id) {
        tokenRepo.deleteById(id);
    }
}
