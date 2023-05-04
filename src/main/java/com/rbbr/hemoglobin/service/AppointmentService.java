package com.rbbr.hemoglobin.service;

import com.rbbr.hemoglobin.dto.AppointmentDTO;
import com.rbbr.hemoglobin.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface AppointmentService {
    AppointmentDTO saveAppointment(AppointmentDTO appointmentDTO);

    Page<AppointmentDTO> getAppointmentsByDonationCenter(Long donationCenterId, int page, int size);

    Page<AppointmentDTO> getAppointmentsByDonationCenterAndDate(Long donationCenterId, LocalDate date, int page, int size);
}
