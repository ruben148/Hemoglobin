package com.rbbr.hemoglobin.repo;

import com.rbbr.hemoglobin.entity.DonationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationCenterRepo extends JpaRepository<DonationCenter, Long> {

}
