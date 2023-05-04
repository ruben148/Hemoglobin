package com.rbbr.hemoglobin.dto;

import com.rbbr.hemoglobin.entity.DonationCenter;
import com.rbbr.hemoglobin.entity.Donor;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentDTO {
    private Long id;
    private DonationCenterDTO donationCenter;
    private LocalDate date;
    private DonorDTO donor;
    private Boolean emailNotification;
    private Boolean smsNotification;
}
