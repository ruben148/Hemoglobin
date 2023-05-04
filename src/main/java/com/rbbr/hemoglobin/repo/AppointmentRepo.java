package com.rbbr.hemoglobin.repo;

import com.rbbr.hemoglobin.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    @Query("SELECT COUNT(a) FROM Appointment a WHERE a.donationCenter.id = :donationCenterId AND DATE(a.date) = :date")
    int countAppointmentsByDonationCenterIdAndDate(@Param("donationCenterId") Long donationCenterId, @Param("date") LocalDate date);

    Page<Appointment> findByDonationCenterId(Long donationCenterId, Pageable pageable);

    Page<Appointment> findByDonationCenterIdAndDate(Long donationCenterId, LocalDate date, Pageable pageable);

    List<Appointment> findByDate(LocalDate nextDay);
}
