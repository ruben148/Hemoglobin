package com.rbbr.hemoglobin.repo;

import com.rbbr.hemoglobin.entity.DonationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DonationCenterRepo extends JpaRepository<DonationCenter, Long> {

}
