package com.hop.studentmanagement.dto.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class UpdateStudentRequest {

    @Size(max = 100)
    private String name;

    @DecimalMin("0.0")
    @DecimalMax("4.0")
    private Double gpa;


    private Long classRoomId;


    private String schoolYear;

    @Past
    private LocalDate birthday;

    public UpdateStudentRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
