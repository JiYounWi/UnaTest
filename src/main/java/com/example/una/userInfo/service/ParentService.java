package com.example.una.userInfo.service;

import com.example.una.userInfo.dto.ChildDTO;
import com.example.una.userInfo.dto.ParentDTO;
import com.example.una.userInfo.entity.Child;
import com.example.una.userInfo.entity.Parent;
import com.example.una.userInfo.repository.ChildRepository;
import com.example.una.userInfo.repository.ParentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
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

//    public void updateChild(Long childId, ChildDTO childDTO){
//        Optional<Child> optionalChild = childRepository.findById(childId);
//        if(optionalChild.isPresent()){
//            Child child = optionalChild.get();
//
//            // ChildDTO에서 수정할 자녀 정보 추출하여 업데이트
//            child.setChildName(childDTO.getChildName());
//            child.setChildSchool(childDTO.getChildSchool());
//            child.setChildGrade(childDTO.getChildGrade());
//            child.setChildClass(childDTO.getChildClass());
//            child.setChildNumber(childDTO.getChildNumber());
//
//            childRepository.save(child);
//            log.info("Child with ID {} updated successfully.", childId);
//        } else{
//            log.error("Child with ID {} not found.", childId);
//        }
//    }
public void updateChild(Long parentKakaoId, String childName, ChildDTO childDTO){
    Optional<Parent> optionalParent = parentRepository.findByParentKakaoId(parentKakaoId);
    if(optionalParent.isPresent()){
        Parent parent = optionalParent.get();
        // 부모의 자녀 목록에서 해당하는 자녀 찾기
        Optional<Child> optionalChild = parent.getChildren().stream()
                .filter(child -> child.getChildName().equals(childName))
                .findFirst();

        if(optionalChild.isPresent()){
            Child child = optionalChild.get();
            // ChildDTO에서 수정할 자녀 정보 추출하여 업데이트
            child.setChildSchool(childDTO.getChildSchool());
            child.setChildGrade(childDTO.getChildGrade());
            child.setChildClass(childDTO.getChildClass());
            child.setChildNumber(childDTO.getChildNumber());
            child.setChildName(childDTO.getChildName());

            childRepository.save(child);
            log.info("Child with name {} under parent with Kakao ID {} updated successfully.", childName, parentKakaoId);
        } else {
            log.error("Child with name {} not found under parent with Kakao ID {}.", childName, parentKakaoId);
            // 혹은 예외를 던지거나 다른 처리 방법을 선택할 수 있습니다.
        }
    } else{
        log.error("Parent with Kakao ID {} not found", parentKakaoId);
        // 혹은 예외를 던지거나 다른 처리 방법을 선택할 수 있습니다.
    }
}


}
