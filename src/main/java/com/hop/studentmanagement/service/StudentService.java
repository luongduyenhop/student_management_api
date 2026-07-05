package com.hop.studentmanagement.service;

import com.hop.studentmanagement.dto.request.CreateStudentRequest;
import com.hop.studentmanagement.dto.request.UpdateStudentRequest;
import com.hop.studentmanagement.entity.ClassRoom;
import com.hop.studentmanagement.entity.Student;
import com.hop.studentmanagement.exception.DuplicateStudentCodeException;
import com.hop.studentmanagement.exception.StudentNotFoundException;
import com.hop.studentmanagement.repository.ClassRoomRepository;
import com.hop.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
   private final StudentRepository studentRepository;
   private final ClassRoomRepository classRoomRepository;
    public StudentService(StudentRepository studentRepository, ClassRoomRepository classRoomRepository){

        this.studentRepository = studentRepository;
        this.classRoomRepository = classRoomRepository;
    }


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentByID(Long id){

        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Không tìm thấy học sinh"));

    }


    public Student createStudent(CreateStudentRequest request)  {

        if(studentRepository.existsByStudentCode(request.getStudentCode())){
            throw new DuplicateStudentCodeException("Mã sinh viên này đã tồn tại");
        }
        ClassRoom classRoom = classRoomRepository.findById(request.getClassRoomId()).orElseThrow(
                () -> new RuntimeException("Khong tim thay lop nay")
        );

        Student savedStudent = new Student();
        savedStudent.setStudentCode(request.getStudentCode());
        savedStudent.setName(request.getName());
        savedStudent.setClassRoom(classRoom);
        savedStudent.setGpa(request.getGpa());
        savedStudent.setBirthday(request.getBirthday());
        savedStudent.setSchoolYear(request.getSchoolYear());
        studentRepository.save(savedStudent);

        return savedStudent;

    }

    public  Student updateStudent(UpdateStudentRequest request, Long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Không tồn tại học sinh này"));
        ClassRoom classRoom = classRoomRepository.findById(request.getClassRoomId()).orElseThrow(
                () -> new RuntimeException("Khong tim thay lop nay")
        );

        if(request.getName()!= null){
            student.setName(request.getName());
        }
        if(request.getClassRoomId()!=null){
            student.setClassRoom(classRoom);
        }

        if(request.getGpa()!=null){
            student.setGpa(request.getGpa());
        }
         if(request.getBirthday()!=null){
             student.setBirthday(request.getBirthday());
        }
         if(request.getSchoolYear()!=null){
             student.setSchoolYear(request.getSchoolYear());
        }






        return studentRepository.save(student);
    }


}
