package com.hop.studentmanagement.repository;

import com.hop.studentmanagement.entity.Student;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Optional<Student> findByStudentCode (String studentCode);

    List<Student> findByName(String name);

    boolean existsByStudentCode(String studentCode);

    List<Student> findByNameContaining(String keyWord);

    List<Student> findByClassName(String className);

    List<Student> findByGpaGreaterThan(Double gpa);

    long countByClassName(String className);
}
