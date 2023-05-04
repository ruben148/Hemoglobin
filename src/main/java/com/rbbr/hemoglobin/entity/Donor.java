package com.rbbr.hemoglobin.entity;

import com.rbbr.hemoglobin.type.BloodType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("DONOR")
@Getter @Setter @NoArgsConstructor
public class Donor extends User {
    private String firstName;
    private String lastName;
    private String email;
    private String cnp;
    private String phoneNumber;
    private BloodType bloodType;
}
