package com.rbbr.hemoglobin.util;

import com.rbbr.hemoglobin.entity.Appointment;
import com.rbbr.hemoglobin.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailSender implements MessageSender {

    private EmailService emailService;

    public EmailSender(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public boolean isApplicable(Appointment appointment) {
        return appointment.getEmailNotification();
    }

    @Override
    public void sendNotification(Appointment appointment) {
        String to = appointment.getDonor().getEmail();
        String subject = "Appointment Notification";
        String text = "Dear " + appointment.getDonor().getFirstName() + ",\n\n"
                + "Thank you for scheduling an appointment at " + appointment.getDonationCenter().getName() + ".\n"
                + "Your appointment is on " + appointment.getDate().toString() + ".\n\n"
                + "Best regards,\n"
                + "Your Donation Center Team";

        emailService.sendEmail(to, subject, text);
    }
    public void sendConfirmation(Appointment appointment) {
        String to = appointment.getDonor().getEmail();
        String subject = "Appointment Confirmation";
        String text = "Dear " + appointment.getDonor().getFirstName() + ",\n\n"
                + "Thank you for scheduling an appointment at " + appointment.getDonationCenter().getName() + ".\n"
                + "Your appointment is on " + appointment.getDate().toString() + ".\n\n"
                + "Best regards,\n"
                + "Your Donation Center Team";

        emailService.sendEmail(to, subject, text);
    }
}
