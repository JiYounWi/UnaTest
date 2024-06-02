package com.example.una.appointment.Entity;

import com.example.una.userInfo.entity.Parent;
import com.example.una.userInfo.entity.Teacher;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;

    @Column(nullable = false)
    private LocalDate appointmentDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date requestedDate;

    @Column(name = "status")
    private int status;

    @ManyToOne
    @JoinColumn(name = "parent_kakao_id")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "teacher_kakao_id")
    private Teacher teacher;
//    @Column(name = "teacher_kakao_id")
//    private Long teacherKakaoId;

    @Column(length = 255)
    private String description;


}
