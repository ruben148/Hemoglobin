package com.rbbr.hemoglobin.service.impl;

import com.rbbr.hemoglobin.repo.AnnouncementRepo;
import com.rbbr.hemoglobin.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    @Autowired
    AnnouncementRepo announcementRepo;
}
