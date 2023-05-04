package com.rbbr.hemoglobin.util;

import com.rbbr.hemoglobin.entity.Appointment;
import com.rbbr.hemoglobin.service.EmailService;
import com.rbbr.hemoglobin.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageSenderFactory {

    private static EmailService emailService;
    private static SmsService smsService;

    @Autowired
    public void setEmailService(EmailService emailService) {
        MessageSenderFactory.emailService = emailService;
    }

    @Autowired
    public void setSmsService(SmsService smsService) {
        MessageSenderFactory.smsService = smsService;
    }
    public static List<MessageSender> createSenders(Appointment appointment) {
        List<MessageSender> senders = new ArrayList<>();

        senders.add(new EmailSender(emailService));
        senders.add(new SmsSender(smsService));

        return senders;
    }
}
