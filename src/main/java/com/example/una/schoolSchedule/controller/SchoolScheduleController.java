package com.example.una.schoolSchedule.controller;

import com.example.una.schoolSchedule.service.SchoolScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class SchoolScheduleController {
    private final SchoolScheduleService schoolScheduleService;

    @Autowired
    public SchoolScheduleController(SchoolScheduleService schoolScheduleService) {
        this.schoolScheduleService = schoolScheduleService;
    }

    @GetMapping("/resultSchoolSchedule")
    public String ResultSchoolSchedule(){
        return "성공";
    }

    @PostMapping("/getSchoolSchedule")
    public String getSchoolSchedule(@RequestBody Map<String, String> requestBody) throws IOException {
        //return에 넣으면 학사일정 반환
//        schoolScheduleService.getSchoolSchedule(requestBody);
        return ResultSchoolSchedule();
    }
}
