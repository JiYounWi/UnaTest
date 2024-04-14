package com.example.una.schoolSchedule.repository;

import com.example.una.schoolSchedule.dto.SchoolScheduleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public abstract class SchoolScheduleRepository implements JpaRepository<SchoolScheduleDTO, Long> {
}
