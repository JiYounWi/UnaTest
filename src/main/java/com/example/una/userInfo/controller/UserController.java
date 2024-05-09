package com.example.una.userInfo.controller;

import com.example.una.userInfo.dto.ParentDTO;
import com.example.una.userInfo.dto.TeacherDTO;
import com.example.una.userInfo.service.ParentService;
import com.example.una.userInfo.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ParentService parentService;

    @PostMapping("/save-teacher")
    private void saveTeacher(@RequestBody TeacherDTO teacherDTO){
        teacherService.saveTeacher(teacherDTO);
    }

    @PostMapping("/save-parent")
    private void saveParent(@RequestBody ParentDTO parentDTO){
        parentService.saveParent(parentDTO);
    }
}
