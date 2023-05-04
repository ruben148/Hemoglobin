package com.rbbr.hemoglobin.service.impl;

import com.rbbr.hemoglobin.dto.DoctorDTO;
import com.rbbr.hemoglobin.entity.Doctor;
import com.rbbr.hemoglobin.entity.Donor;
import com.rbbr.hemoglobin.mapper.DoctorMapper;
import com.rbbr.hemoglobin.repo.DoctorRepo;
import com.rbbr.hemoglobin.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorRepo doctorRepo;
    @Autowired
    DoctorMapper doctorMapper;

    @Override
    public DoctorDTO findById(Long id) {
        Optional<Doctor> doctor = doctorRepo.findById(id);
        return doctor.map(value -> doctorMapper.toDoctorDTO(value)).orElse(null);
    }

    public Page<DoctorDTO> findAll(String search, int page) {

        Pageable pageable = PageRequest.of(page, 20);
        if(search == null || search.isEmpty())
            return doctorRepo.findAll(pageable).map(DoctorMapper::toDoctorDTO);
        Page<Doctor> doctors = doctorRepo.findBySearch(search, pageable);
        return doctors.map(DoctorMapper::toDoctorDTO);
    }

    @Override
    public DoctorDTO update(DoctorDTO doctorDTO) {
        Doctor doctorInitial = doctorRepo.findById(doctorDTO.getId()).orElse(null);
        Doctor doctor = doctorMapper.toDoctor(doctorInitial, doctorDTO);
        Doctor doctorModified = doctorRepo.save(doctor);
        return doctorMapper.toDoctorDTO(doctorModified);
    }

    @Override
    public void delete(Long id) {
        doctorRepo.deleteById(id);
    }
}
