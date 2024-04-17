package com.example.una.schoolSchedule.repository;

import com.example.una.schoolSchedule.domain.SchoolSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolScheduleRepository extends JpaRepository<SchoolSchedule, Long> {
}
