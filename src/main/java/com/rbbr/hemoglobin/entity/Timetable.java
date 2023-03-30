package com.rbbr.hemoglobin.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "timetable")
@Getter @Setter @NoArgsConstructor
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    int startMonday, endMonday;
    int startTuesday, endTuesday;
    int startWednesday, endWednesday;
    int startThursday, endThursday;
    int startFriday, endFriday;
    int startSaturday, endSaturday;
    int startSunday, endSunday;
}
