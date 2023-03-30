package com.rbbr.hemoglobin.repo;

import com.rbbr.hemoglobin.entity.Doctor;
import com.rbbr.hemoglobin.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByUsernameAndPassword(String username, String password);
}
