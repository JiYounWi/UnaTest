package com.example.una.schoolSchedule.entity;

import java.io.Serializable;

public class SchoolScheduleId implements Serializable {
    private String sdSchulCode;
    private String schulNm;

    public SchoolScheduleId(String sdSchulCode, String schulNm) {
        this.sdSchulCode = sdSchulCode;
        this.schulNm = schulNm;
    }

    public String getSdSchulCode() {
        return sdSchulCode;
    }

    public void setSdSchulCode(String sdSchulCode) {
        this.sdSchulCode = sdSchulCode;
    }

    public String getSchulNm() {
        return schulNm;
    }

    public void setSchulNm(String schulNm) {
        this.schulNm = schulNm;
    }
}
