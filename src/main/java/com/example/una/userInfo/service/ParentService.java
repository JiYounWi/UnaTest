package com.example.una.userInfo.service;

import com.example.una.userInfo.dto.ParentDTO;
import com.example.una.userInfo.entity.Parent;
import com.example.una.userInfo.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    public void saveParent(ParentDTO parentDTO){
        Parent parent = new Parent();

        parent.setParentName(parentDTO.getParentName());
        parent.setParentEmail(parentDTO.getParentEmail());
        parent.setParentPhoneNumber(parentDTO.getParentPhoneNumber());
        parent.setParentKakaoId(parentDTO.getParentKakaoId());
        parent.setChildNumber(parentDTO.getChildNumber());
        parent.setChildGrade(parentDTO.getChildGrade());
        parent.setChildSchool(parentDTO.getChildSchool());
        parent.setChildClass(parentDTO.getChildClass());
        parent.setChildName(parentDTO.getChildName());
        parentRepository.save(parent);
    }
}
