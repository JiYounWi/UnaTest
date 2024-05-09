package com.example.una.userInfo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "parentTest")
@Getter
@Setter
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "parent_email")
    private String parentEmail;

    @Column(name = "parent_name")
    private String parentName;

    @Column(name = "parent_phone_number")
    private String parentPhoneNumber;

    @Column(name = "parent_kakao_id")
    private Long parentKakaoId;

    @Column(name = "child_name")
    private String childName;

    @Column(name = "child_school")
    private String childSchool;

    @Column(name = "child_grade")
    private int childGrade;

    @Column(name = "child_class")
    private int childClass;

    @Column(name = "child_number")
    private int childNumber;
}
