package com.rbbr.hemoglobin.mapper;

import com.rbbr.hemoglobin.dto.AppointmentDTO;
import com.rbbr.hemoglobin.entity.Appointment;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {
    public static AppointmentDTO toAppointmentDTO(Appointment appointment){
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setId(appointment.getId());
        appointmentDTO.setDonationCenter(DonationCenterMapper.toDonationCenterDTO(appointment.getDonationCenter()));
        appointmentDTO.setDate(appointment.getDate());
        appointmentDTO.setDonor(DonorMapper.toDonorDTO(appointment.getDonor()));
        appointmentDTO.setEmailNotification(appointment.getEmailNotification());
        appointmentDTO.setSmsNotification(appointment.getSmsNotification());
        return appointmentDTO;
    }
}
