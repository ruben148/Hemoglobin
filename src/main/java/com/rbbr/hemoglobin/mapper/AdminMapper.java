package com.rbbr.hemoglobin.mapper;

import com.rbbr.hemoglobin.dto.AdminDTO;
import com.rbbr.hemoglobin.dto.DonorCreateDTO;
import com.rbbr.hemoglobin.dto.DonorDTO;
import com.rbbr.hemoglobin.entity.Admin;
import com.rbbr.hemoglobin.entity.Donor;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {
    public AdminDTO toAdminDTO(Admin admin){
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setId(admin.getId());
        adminDTO.setUsername(admin.getUsername());
        return adminDTO;
    }
}
