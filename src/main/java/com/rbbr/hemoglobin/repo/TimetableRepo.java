package com.rbbr.hemoglobin.repo;

import com.rbbr.hemoglobin.entity.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableRepo extends JpaRepository<Timetable, Long> {
}
