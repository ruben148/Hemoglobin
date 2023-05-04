package com.rbbr.hemoglobin.mapper;

import com.rbbr.hemoglobin.dto.DonorCreateDTO;
import com.rbbr.hemoglobin.dto.DonorDTO;
import com.rbbr.hemoglobin.entity.Donor;
import org.springframework.stereotype.Component;

@Component
public class DonorMapper {

    public static Donor toDonor(DonorCreateDTO donorCreateDTO){
        Donor donor = new Donor();
        donor.setUsername(donorCreateDTO.getUsername());
        donor.setCnp(donorCreateDTO.getCnp());
        donor.setEmail(donorCreateDTO.getEmail());
        donor.setPhoneNumber(donorCreateDTO.getPhoneNumber());
        donor.setPassword(donorCreateDTO.getPassword());
        donor.setFirstName(donorCreateDTO.getFirstName());
        donor.setLastName(donorCreateDTO.getLastName());
        return donor;
    }

    public static DonorDTO toDonorDTO(Donor donor){
        DonorDTO donorDTO = new DonorDTO();
        donorDTO.setId(donor.getId());
        donorDTO.setCnp(donor.getCnp());
        donorDTO.setEmail(donor.getEmail());
        donorDTO.setUsername(donor.getUsername());
        donorDTO.setBloodType(donor.getBloodType());
        donorDTO.setPhoneNumber(donor.getPhoneNumber());
        donorDTO.setFirstName(donor.getFirstName());
        donorDTO.setLastName(donor.getLastName());
        return donorDTO;
    }

    public static Donor toDonor(Donor donor, DonorDTO donorDTO) {
        if (donorDTO.getCnp() != null)
            donor.setCnp(donorDTO.getCnp());
        if (donorDTO.getEmail() != null)
            donor.setEmail(donorDTO.getEmail());
        if (donorDTO.getUsername() != null)
            donor.setUsername(donorDTO.getUsername());
        if (donorDTO.getBloodType() != null)
            donor.setBloodType(donorDTO.getBloodType());
        if (donorDTO.getPhoneNumber() != null)
            donor.setPhoneNumber(donorDTO.getPhoneNumber());
        if (donorDTO.getFirstName() != null)
            donor.setFirstName(donorDTO.getFirstName());
        if (donorDTO.getLastName() != null)
            donor.setLastName(donorDTO.getLastName());
        return donor;
    }
}
