package com.example.una.schoolSchedule.repository;

import com.example.una.schoolSchedule.domain.SchoolSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolScheduleRepository extends JpaRepository<SchoolSchedule, Long> {
    Optional<SchoolSchedule> findBySdSchulCode(String sdSchulCode);
}

