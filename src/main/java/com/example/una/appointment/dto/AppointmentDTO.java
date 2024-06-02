package com.example.una.appointment.dto;

import com.example.una.userInfo.entity.Parent;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppointmentDTO {
    private int appointmentId;
    private LocalDate appointmentDate;
    private Date requestedDate;
    private int status;

//    @NotNull
//    private Long parentKakaoId;

    private Long parentKakaoId;
    private String parentName; // 추가

    @NotNull
    private Long teacherKakaoId;
    private String teacherName; // 추가

    private String description;
}
