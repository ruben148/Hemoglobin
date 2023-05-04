package com.rbbr.hemoglobin.service.impl;

import com.rbbr.hemoglobin.dto.AppointmentDTO;
import com.rbbr.hemoglobin.entity.Appointment;
import com.rbbr.hemoglobin.entity.DonationCenter;
import com.rbbr.hemoglobin.mapper.AppointmentMapper;
import com.rbbr.hemoglobin.repo.AppointmentRepo;
import com.rbbr.hemoglobin.repo.DonationCenterRepo;
import com.rbbr.hemoglobin.repo.DonorRepo;
import com.rbbr.hemoglobin.service.AppointmentService;
import com.rbbr.hemoglobin.util.MessageSender;
import com.rbbr.hemoglobin.util.MessageSenderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    AppointmentRepo appointmentRepo;
    @Autowired
    DonorRepo donorRepo;
    @Autowired
    DonationCenterRepo donationCenterRepo;
    @Autowired
    AppointmentMapper appointmentMapper;

    @Autowired
    MessageSenderFactory messageSenderFactory;

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }

    public Appointment getAppointment(Long id) {
        return appointmentRepo.findById(id).get();
    }

    public Appointment updateAppointment(Appointment appointment, Long id) {
        Optional<Appointment> optionalAppointment = appointmentRepo.findById(id);
        if (optionalAppointment.isPresent()) {
            Appointment appointmentDB = optionalAppointment.get();
            if (appointment.getDate() != null)
                appointmentDB.setDate(appointment.getDate());
            if (appointment.getDonationCenter() != null)
                appointmentDB.setDonationCenter(appointment.getDonationCenter());
            if (appointment.getDate() != null)
                appointmentDB.setDonor(appointment.getDonor());
            return appointmentRepo.save(appointmentDB);
        }
        return null;
    }

    public Page<AppointmentDTO> getAppointmentsByDonationCenter(Long donationCenterId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Appointment> appointments = appointmentRepo.findByDonationCenterId(donationCenterId, pageable);
        return appointments.map(AppointmentMapper::toAppointmentDTO);
    }

    public Page<AppointmentDTO> getAppointmentsByDonationCenterAndDate(Long donationCenterId, LocalDate date, int page, int size) {
        return appointmentRepo.findByDonationCenterIdAndDate(donationCenterId, date, PageRequest.of(page, size))
                .map(AppointmentMapper::toAppointmentDTO);
    }

    public AppointmentDTO saveAppointment(AppointmentDTO appointmentDTO) {
        DonationCenter donationCenter = donationCenterRepo.findById(appointmentDTO.getDonationCenter().getId()).orElse(null);

        LocalDate appointmentDate = appointmentDTO.getDate();
        int appointmentCount = appointmentRepo.countAppointmentsByDonationCenterIdAndDate(appointmentDTO.getDonationCenter().getId(), appointmentDate);
        if (appointmentCount >= donationCenter.getMaxDonations()) {
            return null;
        }

        Appointment appointment = new Appointment();
        appointment.setDonationCenter(donationCenter);
        appointment.setDate(appointmentDate);
        appointment.setDonor(donorRepo.findById(appointmentDTO.getDonor().getId()).orElse(null));
        appointment.setEmailNotification(appointmentDTO.getEmailNotification());
        appointment.setSmsNotification(appointmentDTO.getSmsNotification());

        List<MessageSender> senders = MessageSenderFactory.createSenders(appointment);
        for (MessageSender sender : senders)
            if(sender.isApplicable(appointment))
                sender.sendConfirmation(appointment);

        Appointment savedAppointment = appointmentRepo.save(appointment);
        return appointmentMapper.toAppointmentDTO(savedAppointment);
    }

    @Scheduled(cron = "0 0 0 * * ?") // This will run at midnight every day
    public void sendScheduledNotifications() {
        LocalDate nextDay = LocalDate.now().plusDays(1);
        List<Appointment> appointments = appointmentRepo.findByDate(nextDay);

        for (Appointment appointment : appointments) {
            List<MessageSender> senders = MessageSenderFactory.createSenders(appointment);
            for (MessageSender sender : senders)
                if(sender.isApplicable(appointment))
                    sender.sendNotification(appointment);
        }
    }


    public void deleteAppointment(Long id){
        appointmentRepo.deleteById(id);
    }
}
