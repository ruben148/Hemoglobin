package com.rbbr.hemoglobin.entity;

import com.rbbr.hemoglobin.type.BloodType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "donor")
@Getter @Setter @NoArgsConstructor
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String cnp;
    private String phoneNumber;
    private BloodType bloodType;
}
