package com.rbbr.hemoglobin.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctor")
@Getter @Setter @NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String username;
    String firstName;
    String lastName;
    String password;
    String email;
    String cnp;
    String phoneNumber;
    @OneToOne
    DonationCenter donationCenter;
}
