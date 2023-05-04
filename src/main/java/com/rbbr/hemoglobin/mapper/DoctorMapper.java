package com.rbbr.hemoglobin.mapper;

import com.rbbr.hemoglobin.dto.DoctorCreateDTO;
import com.rbbr.hemoglobin.dto.DoctorDTO;
import com.rbbr.hemoglobin.entity.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {
    public Doctor toDoctor(DoctorCreateDTO doctorCreateDTO){
        Doctor doctor = new Doctor();
        doctor.setUsername(doctorCreateDTO.getUsername());
        doctor.setCnp(doctorCreateDTO.getCnp());
        doctor.setEmail(doctorCreateDTO.getEmail());
        doctor.setPhoneNumber(doctorCreateDTO.getPhoneNumber());
        doctor.setPassword(doctorCreateDTO.getPassword());
        return doctor;
    }

    public Doctor toDoctor(Doctor doctor, DoctorDTO doctorDTO){
        if(doctorDTO.getUsername() != null)
            doctor.setUsername(doctorDTO.getUsername());
        if(doctorDTO.getCnp() != null)
            doctor.setCnp(doctorDTO.getCnp());
        if(doctorDTO.getEmail() != null)
            doctor.setEmail(doctorDTO.getEmail());
        if(doctorDTO.getPhoneNumber() != null)
            doctor.setPhoneNumber(doctorDTO.getPhoneNumber());
        if(doctorDTO.getFirstName() != null)
            doctor.setFirstName(doctorDTO.getFirstName());
        if(doctorDTO.getLastName() != null)
            doctor.setLastName(doctorDTO.getLastName());
        return doctor;
    }

    public static DoctorDTO toDoctorDTO(Doctor doctor){
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setId(doctor.getId());
        doctorDTO.setCnp(doctor.getCnp());
        doctorDTO.setEmail(doctor.getEmail());
        doctorDTO.setUsername(doctor.getUsername());
        doctorDTO.setDonationCenter(DonationCenterMapper.toDonationCenterDTO(doctor.getDonationCenter()));
        doctorDTO.setPhoneNumber(doctor.getPhoneNumber());
        doctorDTO.setFirstName(doctor.getFirstName());
        doctorDTO.setLastName(doctor.getLastName());
        return doctorDTO;
    }
}
