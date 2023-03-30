package com.rbbr.hemoglobin.repo;

import com.rbbr.hemoglobin.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepo extends JpaRepository<Announcement, Long> {
}
