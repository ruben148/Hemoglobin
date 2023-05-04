package com.rbbr.hemoglobin.service;

import com.rbbr.hemoglobin.dto.DonationCenterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonationCenterService {
    Page<DonationCenterDTO> getAllDonationCenters(int page, int pageSize);

    DonationCenterDTO findById(Long id);

    boolean[] getAvailability(Long donationCenterId);
}
