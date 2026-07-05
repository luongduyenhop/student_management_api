    package com.hop.studentmanagement.controller;

    import com.hop.studentmanagement.dto.request.CreateStudentRequest;
    import com.hop.studentmanagement.dto.request.UpdateStudentRequest;
    import com.hop.studentmanagement.dto.respone.CreateStudentResponse;
    import com.hop.studentmanagement.entity.Student;
    import jakarta.validation.Valid;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import com.hop.studentmanagement.service.StudentService;

    import java.time.LocalDateTime;
    import java.util.List;

    @RestController
    @RequestMapping("/students")
    public class StudentController {

        private final StudentService studentService;

        public StudentController(StudentService studentService) {
            this.studentService = studentService;
        }

        @GetMapping
        public List<Student> getAllStudents(){
            return studentService.getAllStudents();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Student> getStudentByID(@PathVariable Long id){
            Student student =  studentService.getStudentByID(id);
            return new ResponseEntity<>(student,HttpStatus.OK);

        }

        @PostMapping
        public ResponseEntity<CreateStudentResponse> createStudent(
                @RequestBody @Valid CreateStudentRequest createStudentRequest
                )  {
                Student newStudent = studentService.createStudent(createStudentRequest);
            CreateStudentResponse response = new CreateStudentResponse(
                    newStudent.getId(),
                    newStudent.getStudentCode(),
                    newStudent.getName(),
                    newStudent.getClassRoom().getId(),
                    newStudent.getSchoolYear(),
                    newStudent.getGpa(),
                    newStudent.getBirthday(),
                    LocalDateTime.now()
            );
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<UpdateStudentRequest> updateStudent(
                @Valid @RequestBody UpdateStudentRequest request,@PathVariable Long id){
            Student student = studentService.updateStudent(request,id);
            UpdateStudentRequest request1 = new UpdateStudentRequest();

            request1.setName(student.getName());
            request1.setClassRoomId(student.getClassRoom().getId());
            request1.setSchoolYear(student.getSchoolYear());
            request1.setGpa(student.getGpa());
            request1.setBirthday(student.getBirthday());

            return new ResponseEntity<>(request1,HttpStatus.OK);
        }
    }
