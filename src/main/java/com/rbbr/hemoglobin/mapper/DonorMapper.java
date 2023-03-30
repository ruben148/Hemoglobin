package com.rbbr.hemoglobin.mapper;

import com.rbbr.hemoglobin.dto.DonorCreateDTO;
import com.rbbr.hemoglobin.dto.DonorDTO;
import com.rbbr.hemoglobin.entity.Donor;
import org.springframework.stereotype.Component;

@Component
public class DonorMapper {

    public Donor toDonor(DonorCreateDTO donorCreateDTO){
        Donor donor = new Donor();
        donor.setUsername(donorCreateDTO.getUsername());
        donor.setCnp(donorCreateDTO.getCnp());
        donor.setEmail(donorCreateDTO.getEmail());
        donor.setPhoneNumber(donorCreateDTO.getPhoneNumber());
        donor.setPassword(donorCreateDTO.getPassword());
        return donor;
    }

    public DonorDTO toDonorDTO(Donor donor){
        DonorDTO donorDTO = new DonorDTO();
        donorDTO.setId(donor.getId());
        donorDTO.setCnp(donor.getCnp());
        donorDTO.setEmail(donor.getEmail());
        donorDTO.setUsername(donor.getUsername());
        donorDTO.setBloodType(donor.getBloodType());
        donorDTO.setPhoneNumber(donor.getPhoneNumber());
        return donorDTO;
    }
}
