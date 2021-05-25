package org.example.Word.model;

import java.io.Serializable;

public class WLearnedword implements Serializable {
    private Long id;

    private Long uid;

    private Long bid;

    private Long wid;

    private Integer iscorrect;

    private Integer studyTimeYear;

    private Integer studyTimeMonth;

    private Integer studyTimeDay;

    private String studyTime;

    private Integer recent;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public Long getWid() {
        return wid;
    }

    public void setWid(Long wid) {
        this.wid = wid;
    }

    public Integer getIscorrect() {
        return iscorrect;
    }

    public void setIscorrect(Integer iscorrect) {
        this.iscorrect = iscorrect;
    }

    public Integer getStudyTimeYear() {
        return studyTimeYear;
    }

    public void setStudyTimeYear(Integer studyTimeYear) {
        this.studyTimeYear = studyTimeYear;
    }

    public Integer getStudyTimeMonth() {
        return studyTimeMonth;
    }

    public void setStudyTimeMonth(Integer studyTimeMonth) {
        this.studyTimeMonth = studyTimeMonth;
    }

    public Integer getStudyTimeDay() {
        return studyTimeDay;
    }

    public void setStudyTimeDay(Integer studyTimeDay) {
        this.studyTimeDay = studyTimeDay;
    }

    public String getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(String studyTime) {
        this.studyTime = studyTime;
    }

    public Integer getRecent() {
        return recent;
    }

    public void setRecent(Integer recent) {
        this.recent = recent;
    }
}