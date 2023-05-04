package com.rbbr.hemoglobin.repo;

import com.rbbr.hemoglobin.entity.Token;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepo extends JpaRepository<Token, Long> {
    @Transactional
    void deleteById(String id);
}