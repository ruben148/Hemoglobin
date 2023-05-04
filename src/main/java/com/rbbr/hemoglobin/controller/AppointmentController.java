package com.rbbr.hemoglobin.controller;

import com.rbbr.hemoglobin.dto.AppointmentDTO;
import com.rbbr.hemoglobin.entity.Appointment;
import com.rbbr.hemoglobin.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentDTO> saveAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        AppointmentDTO savedAppointment = appointmentService.saveAppointment(appointmentDTO);
        if(savedAppointment == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAppointment);
    }

    @GetMapping("/donation-center/{donationCenterId}")
    public ResponseEntity<Page<AppointmentDTO>> getAppointmentsByDonationCenter(
            @PathVariable Long donationCenterId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        System.out.println("Trying to send appointments at donation center " + donationCenterId + "...");
        Page<AppointmentDTO> appointments = appointmentService.getAppointmentsByDonationCenter(donationCenterId, page, size);
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/donation-center/{donationCenterId}/date")
    public ResponseEntity<Page<AppointmentDTO>> getAppointmentsByDonationCenterAndDate(
            @PathVariable Long donationCenterId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        System.out.println("Trying to send appointments at donation center " + donationCenterId + " on " + date + "...");
        Page<AppointmentDTO> appointments = appointmentService.getAppointmentsByDonationCenterAndDate(donationCenterId, date, page, size);
        return ResponseEntity.ok(appointments);
    }

}