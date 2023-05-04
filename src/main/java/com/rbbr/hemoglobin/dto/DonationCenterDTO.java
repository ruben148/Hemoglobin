package com.rbbr.hemoglobin.dto;

import com.rbbr.hemoglobin.entity.Timetable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DonationCenterDTO {
    Long id;
    String name;
    String description;
    String address;
    int maxDonations;
    Timetable timetable;
}
