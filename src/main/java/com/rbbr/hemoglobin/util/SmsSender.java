package com.rbbr.hemoglobin.util;

import com.rbbr.hemoglobin.entity.Appointment;
import com.rbbr.hemoglobin.service.SmsService;
import com.rbbr.hemoglobin.service.impl.ClickSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class SmsSender implements MessageSender {

    private SmsService smsService;

    public SmsSender(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public boolean isApplicable(Appointment appointment) {
        return appointment.getSmsNotification();
    }

    @Override
    public void sendNotification(Appointment appointment) {
        String phoneNumber = appointment.getDonor().getPhoneNumber();
        String message = "Your appointment at " + appointment.getDonationCenter().getName() +
                " is scheduled for " + appointment.getDate().toString() + ".";
        smsService.sendSms(phoneNumber, message);
    }

    @Override
    public void sendConfirmation(Appointment appointment) {
        String phoneNumber = appointment.getDonor().getPhoneNumber();
        String message = "Your appointment at " + appointment.getDonationCenter().getName() +
                " is scheduled for " + appointment.getDate().toString() + ".";
        smsService.sendSms(phoneNumber, message);
    }
}