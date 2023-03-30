package com.rbbr.hemoglobin.service.impl;

import com.rbbr.hemoglobin.repo.ResultRepo;
import com.rbbr.hemoglobin.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    ResultRepo resultRepo;
}
