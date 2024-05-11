package com.example.una.userInfo.service;

import com.example.una.userInfo.dto.ChildDTO;
import com.example.una.userInfo.dto.ParentDTO;
import com.example.una.userInfo.entity.Child;
import com.example.una.userInfo.entity.Parent;
import com.example.una.userInfo.repository.ChildRepository;
import com.example.una.userInfo.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ChildRepository childRepository;

    public ResponseEntity<String> saveParent(ParentDTO request) {
        try {
            // 부모 정보 저장
            Parent parent = new Parent();
            parent.setParentName(request.getParentName());
            parent.setParentEmail(request.getParentEmail());
            parent.setParentPhoneNumber(request.getParentPhoneNumber());
            parent.setParentKakaoId(request.getParentKakaoId());

            // 자식 정보 저장
            List<ChildDTO> childDTOList = request.getChildren();
            List<Child> children = new ArrayList<>();
            for (ChildDTO childDTO : childDTOList) {
                Child child = new Child();
                child.setChildName(childDTO.getChildName());
                child.setChildSchool(childDTO.getChildSchool());
                child.setChildGrade(childDTO.getChildGrade());
                child.setChildClass(childDTO.getChildClass());
                child.setChildNumber(childDTO.getChildNumber());
                child.setParent(parent);
                children.add(child);
            }
            parent.setChildren(children);

            parentRepository.save(parent);

            return new ResponseEntity<>("Child added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add child", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
