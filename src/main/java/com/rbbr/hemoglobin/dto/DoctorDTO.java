package com.rbbr.hemoglobin.dto;

import com.rbbr.hemoglobin.entity.DonationCenter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DoctorDTO {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String cnp;
    private String phoneNumber;
    private DonationCenter donationCenter;
}
