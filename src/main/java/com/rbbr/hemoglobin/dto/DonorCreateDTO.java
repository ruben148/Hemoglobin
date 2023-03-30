package com.rbbr.hemoglobin.dto;

import com.rbbr.hemoglobin.type.BloodType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DonorCreateDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String cnp;
    private String phoneNumber;
}
