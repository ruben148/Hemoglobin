package com.rbbr.hemoglobin.repo;

import com.rbbr.hemoglobin.entity.Doctor;
import com.rbbr.hemoglobin.entity.Donor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByUsernameAndPassword(String username, String password);

    Optional<Doctor> findByUsername(String username);

    Page<Doctor> findByLastName(String lastName, Pageable pageable);

    Page<Doctor> findAll(Pageable pageable);

    @Query("SELECT d FROM Doctor d WHERE " +
            "LOWER(d.firstName) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(d.lastName) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<Doctor> findBySearch(@Param("search") String search, Pageable pageable);

}
