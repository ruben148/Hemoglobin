package com.rbbr.hemoglobin.service.impl;

import com.rbbr.hemoglobin.entity.Appointment;
import com.rbbr.hemoglobin.repo.AppointmentRepo;
import com.rbbr.hemoglobin.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    AppointmentRepo appointmentRepo;

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

    public void deleteAppointment(Long id){
        appointmentRepo.deleteById(id);
    }
}
