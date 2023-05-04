package com.rbbr.hemoglobin.util;

import com.rbbr.hemoglobin.entity.Appointment;
import org.springframework.stereotype.Component;

@Component
public interface MessageSender {
    boolean isApplicable(Appointment appointment);
    void sendNotification(Appointment appointment);
    void sendConfirmation(Appointment appointment);
}