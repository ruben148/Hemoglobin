package com.rbbr.hemoglobin.mapper;

import com.rbbr.hemoglobin.dto.DonationCenterDTO;
import com.rbbr.hemoglobin.entity.DonationCenter;
import org.springframework.stereotype.Component;

@Component
public class DonationCenterMapper {
    public static DonationCenterDTO toDonationCenterDTO(DonationCenter donationCenter){
        DonationCenterDTO donationCenterDTO = new DonationCenterDTO();
        donationCenterDTO.setId(donationCenter.getId());
        donationCenterDTO.setName(donationCenter.getName());
        donationCenterDTO.setDescription(donationCenter.getDescription());
        donationCenterDTO.setAddress(donationCenter.getAddress());
        donationCenterDTO.setMaxDonations(donationCenter.getMaxDonations());
        donationCenterDTO.setTimetable(donationCenter.getTimetable());
        return donationCenterDTO;
    }
}
