package com.hop.studentmanagement.dto.respone;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreateStudentResponse {
    private Long id;

    private String studentCode;

    private String name;

    private Long classRoomId;

    private String schoolYear;

    private Double gpa;

    private LocalDate birthday;

    private LocalDateTime createdAt;

    public CreateStudentResponse(Long id, String studentCode, String name, Long classRoomId, String schoolYear, Double gpa, LocalDate birthday, LocalDateTime createdAt) {
        this.id = id;
        this.studentCode = studentCode;
        this.name = name;
        this.classRoomId = classRoomId;
        this.schoolYear = schoolYear;
        this.gpa = gpa;
        this.birthday = birthday;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(Long classRoomId) {
        this.classRoomId = classRoomId;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
