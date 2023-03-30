package com.rbbr.hemoglobin.service.impl;

import com.rbbr.hemoglobin.repo.DonationCenterRepo;
import com.rbbr.hemoglobin.service.DonationCenterService;
import org.springframework.stereotype.Service;

@Service
public class DonationCenterServiceImpl implements DonationCenterService {
    DonationCenterRepo donationCenterRepo;
}
