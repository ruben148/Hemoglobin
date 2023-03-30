package com.rbbr.hemoglobin.repo;

import com.rbbr.hemoglobin.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DonorRepo extends JpaRepository<Donor, Long> {
    Optional<Donor> findByUsernameAndPassword(String username, String password);
}
