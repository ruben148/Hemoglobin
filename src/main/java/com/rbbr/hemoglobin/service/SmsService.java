package com.rbbr.hemoglobin.service;

import org.springframework.stereotype.Service;

@Service
public interface SmsService {
    void sendSms(String to, String message);
}
