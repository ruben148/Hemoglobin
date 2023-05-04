package com.rbbr.hemoglobin.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "donation_center")
@Getter @Setter @NoArgsConstructor
public class DonationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String description;
    String address;
    int maxDonations;
    @OneToOne
    Timetable timetable;
    @OneToMany(mappedBy = "donationCenter")
    private List<Appointment> appointments;
}