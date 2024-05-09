package com.example.una.userInfo.service;

import com.example.una.userInfo.dto.TeacherDTO;
import com.example.una.userInfo.entity.Teacher;
import com.example.una.userInfo.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public void saveTeacher(TeacherDTO teacherDTO){
        Teacher teacher = new Teacher();

        teacher.setTeacherSchool(teacherDTO.getTeacherSchool());
        teacher.setTeacherGrade(teacherDTO.getTeacherGrade());
        teacher.setTeacherClass(teacherDTO.getTeacherClass());
        teacher.setTeacherEmail(teacherDTO.getTeacherEmail());
        teacher.setTeacherName(teacherDTO.getTeacherName());
        teacher.setTeacherPhoneNumber(teacherDTO.getTeacherPhoneNumber());
        teacher.setTeacherKakaoId(teacherDTO.getTeacherKakaoId());
        teacherRepository.save(teacher);
    }
}
