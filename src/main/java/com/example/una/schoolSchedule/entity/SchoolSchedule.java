package com.example.una.schoolSchedule.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "school_schedule_B10")
@IdClass(SchoolScheduleId.class)
public class SchoolSchedule {

    @Column(name = "ATPT_OFCDC_SC_CODE")
    private String atptOfcdcScCode;

    @Column(name = "ATPT_OFCDC_SC_NM")
    private String atptOfcdcScNm;

    @Id
    @Column(name = "SD_SCHUL_CODE")
    private String sdSchulCode;

    @Id
    @Column(name = "SCHUL_NM")
    private String schulNm;

    @Column(name = "AY")
    private String ay;

    @Column(name = "DGHT_CRSE_SC_NM")
    private String dghtCrseScNm;

    @Column(name = "SCHUL_CRSE_SC_NM")
    private String schulCrseScNm;

    @Column(name = "SBTR_DD_SC_NM")
    private String sbtrDdScNm;

    @Column(name = "AA_YMD")
    private String aaYmd;

    @Column(name = "EVENT_NM")
    private String eventNm;

    @Column(name = "EVENT_CNTNT")
    private String eventCntnt;

    @Column(name = "ONE_GRADE_EVENT_YN")
    private String oneGradeEventYn;

    @Column(name = "TW_GRADE_EVENT_YN")
    private String twGradeEventYn;

    @Column(name = "THREE_GRADE_EVENT_YN")
    private String threeGradeEventYn;

    @Column(name = "FR_GRADE_EVENT_YN")
    private String frGradeEventYn;

    @Column(name = "FIV_GRADE_EVENT_YN")
    private String fivGradeEventYn;

    @Column(name = "SIX_GRADE_EVENT_YN")
    private String sixGradeEventYn;

    @Column(name = "LOAD_DTM")
    private Date loadDtm;

    public SchoolSchedule(String atptOfcdcScCode, String atptOfcdcScNm, String sdSchulCode, String schulNm, String ay, String dghtCrseScNm, String schulCrseScNm, String sbtrDdScNm, String aaYmd, String eventNm, String eventCntnt, String oneGradeEventYn, String twGradeEventYn, String threeGradeEventYn, String frGradeEventYn, String fivGradeEventYn, String sixGradeEventYn, Date loadDtm) {
        this.atptOfcdcScCode = atptOfcdcScCode;
        this.atptOfcdcScNm = atptOfcdcScNm;
        this.sdSchulCode = sdSchulCode;
        this.schulNm = schulNm;
        this.ay = ay;
        this.dghtCrseScNm = dghtCrseScNm;
        this.schulCrseScNm = schulCrseScNm;
        this.sbtrDdScNm = sbtrDdScNm;
        this.aaYmd = aaYmd;
        this.eventNm = eventNm;
        this.eventCntnt = eventCntnt;
        this.oneGradeEventYn = oneGradeEventYn;
        this.twGradeEventYn = twGradeEventYn;
        this.threeGradeEventYn = threeGradeEventYn;
        this.frGradeEventYn = frGradeEventYn;
        this.fivGradeEventYn = fivGradeEventYn;
        this.sixGradeEventYn = sixGradeEventYn;
        this.loadDtm = loadDtm;
    }

    public String getAtptOfcdcScCode() {
        return atptOfcdcScCode;
    }

    public void setAtptOfcdcScCode(String atptOfcdcScCode) {
        this.atptOfcdcScCode = atptOfcdcScCode;
    }

    public String getAtptOfcdcScNm() {
        return atptOfcdcScNm;
    }

    public void setAtptOfcdcScNm(String atptOfcdcScNm) {
        this.atptOfcdcScNm = atptOfcdcScNm;
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

    public String getAy() {
        return ay;
    }

    public void setAy(String ay) {
        this.ay = ay;
    }

    public String getDghtCrseScNm() {
        return dghtCrseScNm;
    }

    public void setDghtCrseScNm(String dghtCrseScNm) {
        this.dghtCrseScNm = dghtCrseScNm;
    }

    public String getSchulCrseScNm() {
        return schulCrseScNm;
    }

    public void setSchulCrseScNm(String schulCrseScNm) {
        this.schulCrseScNm = schulCrseScNm;
    }

    public String getSbtrDdScNm() {
        return sbtrDdScNm;
    }

    public void setSbtrDdScNm(String sbtrDdScNm) {
        this.sbtrDdScNm = sbtrDdScNm;
    }

    public String getAaYmd() {
        return aaYmd;
    }

    public void setAaYmd(String aaYmd) {
        this.aaYmd = aaYmd;
    }

    public String getEventNm() {
        return eventNm;
    }

    public void setEventNm(String eventNm) {
        this.eventNm = eventNm;
    }

    public String getEventCntnt() {
        return eventCntnt;
    }

    public void setEventCntnt(String eventCntnt) {
        this.eventCntnt = eventCntnt;
    }

    public String getOneGradeEventYn() {
        return oneGradeEventYn;
    }

    public void setOneGradeEventYn(String oneGradeEventYn) {
        this.oneGradeEventYn = oneGradeEventYn;
    }

    public String getTwGradeEventYn() {
        return twGradeEventYn;
    }

    public void setTwGradeEventYn(String twGradeEventYn) {
        this.twGradeEventYn = twGradeEventYn;
    }

    public String getThreeGradeEventYn() {
        return threeGradeEventYn;
    }

    public void setThreeGradeEventYn(String threeGradeEventYn) {
        this.threeGradeEventYn = threeGradeEventYn;
    }

    public String getFrGradeEventYn() {
        return frGradeEventYn;
    }

    public void setFrGradeEventYn(String frGradeEventYn) {
        this.frGradeEventYn = frGradeEventYn;
    }

    public String getFivGradeEventYn() {
        return fivGradeEventYn;
    }

    public void setFivGradeEventYn(String fivGradeEventYn) {
        this.fivGradeEventYn = fivGradeEventYn;
    }

    public String getSixGradeEventYn() {
        return sixGradeEventYn;
    }

    public void setSixGradeEventYn(String sixGradeEventYn) {
        this.sixGradeEventYn = sixGradeEventYn;
    }

    public Date getLoadDtm() {
        return loadDtm;
    }

    public void setLoadDtm(Date loadDtm) {
        this.loadDtm = loadDtm;
    }
}
