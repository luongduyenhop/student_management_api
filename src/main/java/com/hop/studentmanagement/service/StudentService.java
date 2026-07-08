package com.hop.studentmanagement.service;

import com.hop.studentmanagement.dto.request.CreateStudentRequest;
import com.hop.studentmanagement.dto.request.UpdateStudentRequest;
import com.hop.studentmanagement.entity.ClassRoom;
import com.hop.studentmanagement.entity.Student;
import com.hop.studentmanagement.exception.DuplicateStudentCodeException;
import com.hop.studentmanagement.exception.ResourceNotFoundException;
import com.hop.studentmanagement.repository.ClassRoomRepository;
import com.hop.studentmanagement.repository.StudentRepository;
import jakarta.transaction.Transactional;
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
                .orElseThrow(() -> new BusinessException(ErrorCode.STUDENT_NOT_FOUND, "Không tìm thấy học sinh có id: " + id));

    }


    public Student createStudent(CreateStudentRequest request)  {

        if(studentRepository.existsByStudentCode(request.getStudentCode())){
            throw new BusinessException(ErrorCode.DUPLICATE_STUDENT_CODE, "Mã sinh viên " + request.getStudentCode() + " đã tồn tại");
        }
        ClassRoom classRoom = getClassRoomOrThrow(request.getClassRoomId());

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

    @Transactional
    public  Student updateStudent(UpdateStudentRequest request, Long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new BusinessException(ErrorCode.STUDENT_NOT_FOUND, "Không tồn tại học sinh này có id: " + id));


        if(request.getName()!= null){
            student.setName(request.getName());
        }
        if(request.getClassRoomId()!=null){
            ClassRoom classRoom = getClassRoomOrThrow(id);
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
         return student;
    }


    private ClassRoom getClassRoomOrThrow(Long id){
        return classRoomRepository.findById(id).orElseThrow(
                () -> new BusinessException(ErrorCode.CLASS_NOT_FOUND, "Không tìm thấy lớp học có id: " + id)
        );
    }

}
