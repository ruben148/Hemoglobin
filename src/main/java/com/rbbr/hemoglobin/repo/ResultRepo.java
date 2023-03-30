package com.rbbr.hemoglobin.repo;

import com.rbbr.hemoglobin.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepo  extends JpaRepository<Result, Long> {
}
