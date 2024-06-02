package com.example.una.chatBot.repository;

import com.example.una.chatBot.entity.GPTResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GPTResponseRepository extends JpaRepository<GPTResponseEntity, Long> {
}
