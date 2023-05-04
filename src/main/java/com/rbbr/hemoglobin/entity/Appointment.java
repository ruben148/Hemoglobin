package com.rbbr.hemoglobin.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "appointment")
@Getter @Setter @NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne
    @JoinColumn(name = "donation_center_id")
    DonationCenter donationCenter;
    @OneToOne
    Donor donor;
    LocalDate date;
    Boolean emailNotification;
    Boolean smsNotification;
    int status;
}