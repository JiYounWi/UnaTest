package com.example.una.schoolSchedule.controller;

import com.example.una.schoolSchedule.repository.SchoolScheduleRepository;
import com.example.una.schoolSchedule.service.SchoolScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SchoolScheduleController {

    private final SchoolScheduleService schoolScheduleService;

    @Autowired
    SchoolScheduleRepository schoolScheduleRepository;

    @GetMapping("/resultSchoolSchedule")
    public String ResultSchoolSchedule(){
        return "성공";
    }

    @PostMapping("/getSchoolSchedule")
    public String GetSchoolSchedule(@RequestBody Map<String, String> requestBody) {
        String sdSchulCode = requestBody.get("SD_SCHUL_CODE");
        schoolScheduleService.fetchAndSaveSchoolSchedule(sdSchulCode);
        return ResultSchoolSchedule();
    }
}
