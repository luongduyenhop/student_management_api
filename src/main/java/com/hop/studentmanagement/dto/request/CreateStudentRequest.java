package com.hop.studentmanagement.dto.request;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

public class CreateStudentRequest {

    @NotBlank
    @Size(min = 5, max = 10)
    private String studentCode;

    @NotBlank
    @Size(max = 100)
    private String name;

    @DecimalMin("0.0")
    @DecimalMax("4.0")
    @NotNull
    private Double gpa;

    @NotBlank
    private Long classRoomId;

    @NotBlank
    private String schoolYear;

    @NotNull
    @Past
    private LocalDate birthday;

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
