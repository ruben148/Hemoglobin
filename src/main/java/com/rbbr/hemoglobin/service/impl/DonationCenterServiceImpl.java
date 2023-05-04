package com.rbbr.hemoglobin.service.impl;

import com.rbbr.hemoglobin.dto.DonationCenterDTO;
import com.rbbr.hemoglobin.entity.DonationCenter;
import com.rbbr.hemoglobin.mapper.DonationCenterMapper;
import com.rbbr.hemoglobin.repo.AppointmentRepo;
import com.rbbr.hemoglobin.repo.DonationCenterRepo;
import com.rbbr.hemoglobin.service.DonationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonationCenterServiceImpl implements DonationCenterService {
    @Autowired
    DonationCenterRepo donationCenterRepo;

    @Autowired
    AppointmentRepo appointmentRepo;

    @Override
    public Page<DonationCenterDTO> getAllDonationCenters(int page, int pageSize) {
        Pageable paging = PageRequest.of(page, pageSize);
        Page<DonationCenter> donationCenters = donationCenterRepo.findAll(paging);
        return donationCenters.map(DonationCenterMapper::toDonationCenterDTO);
    }

    @Override
    public DonationCenterDTO findById(Long id) {
        DonationCenterDTO donationCenterDTO = new DonationCenterDTO();
        DonationCenter donationCenter = donationCenterRepo.findById(id).orElse(null);
        if(donationCenter == null)
            return null;
        return DonationCenterMapper.toDonationCenterDTO(donationCenter);
    }

    public boolean[] getAvailability(Long donationCenterId) {
        DonationCenter donationCenter = donationCenterRepo.findById(donationCenterId).orElse(null);

        int daysInFuture = 60;
        boolean[] availability = new boolean[daysInFuture];

        LocalDate currentDate = LocalDate.now();
        for (int i = 0; i < daysInFuture; i++) {
            LocalDate date = currentDate.plusDays(i);
            int appointmentCount = appointmentRepo.countAppointmentsByDonationCenterIdAndDate(donationCenterId, date);
            availability[i] = appointmentCount < donationCenter.getMaxDonations();
        }

        return availability;
    }
}
