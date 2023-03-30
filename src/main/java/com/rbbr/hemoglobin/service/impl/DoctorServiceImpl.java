package com.rbbr.hemoglobin.service.impl;

import com.rbbr.hemoglobin.dto.DoctorDTO;
import com.rbbr.hemoglobin.entity.Doctor;
import com.rbbr.hemoglobin.mapper.DoctorMapper;
import com.rbbr.hemoglobin.repo.DoctorRepo;
import com.rbbr.hemoglobin.service.DoctorService;
import com.rbbr.hemoglobin.util.SessionStuff;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorRepo doctorRepo;
    @Autowired
    DoctorMapper doctorMapper;
    @Autowired
    SessionStuff sessionStuff;

    @Override
    public DoctorDTO findById(Long id) {
        Optional<Doctor> doctor = doctorRepo.findById(id);
        return doctor.map(value -> doctorMapper.toDoctorDTO(value)).orElse(null);
    }

    @Override
    public DoctorDTO login(String username, String password, HttpServletRequest request) {
        Optional<Doctor> doctor = doctorRepo.findByUsernameAndPassword(username, password);
        if(doctor.isPresent()) {
            sessionStuff.setSessionUserType("doctor", request);
            return doctorMapper.toDoctorDTO(doctor.get());
        }
        else
            return null;
    }

    @Override
    public DoctorDTO update(DoctorDTO doctorDTO) {
        Optional<Doctor> optionalDoctor = doctorRepo.findById(doctorDTO.getId());
        Doctor doctor = doctorMapper.toDoctor(optionalDoctor.get(), doctorDTO);
        return doctorMapper.toDoctorDTO(doctorRepo.save(doctor));
    }

    @Override
    public void delete(Long id) {
        doctorRepo.deleteById(id);
    }
}
