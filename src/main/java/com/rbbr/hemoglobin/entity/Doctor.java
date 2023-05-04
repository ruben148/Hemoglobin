package com.rbbr.hemoglobin.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("DOCTOR")
@Getter @Setter @NoArgsConstructor
public class Doctor extends User {
    String firstName;
    String lastName;
    String email;
    String cnp;
    String phoneNumber;
    @OneToOne
    DonationCenter donationCenter;
}
