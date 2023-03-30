package com.rbbr.hemoglobin.service.impl;

import com.rbbr.hemoglobin.repo.TimetableRepo;
import com.rbbr.hemoglobin.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimetableServiceImpl implements TimetableService {
    @Autowired
    TimetableRepo timetableRepo;
}
