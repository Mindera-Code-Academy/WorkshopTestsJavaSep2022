package mindera.mindswap.aveiro.module2.springboot.myfirstapi.controllers;

import mindera.mindswap.aveiro.module2.springboot.myfirstapi.command.StudentDto;
import mindera.mindswap.aveiro.module2.springboot.myfirstapi.command.StudentUpdateDto;
import mindera.mindswap.aveiro.module2.springboot.myfirstapi.persistance.models.Student;
import mindera.mindswap.aveiro.module2.springboot.myfirstapi.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return this.studentService.getStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable("id") Long id) {
        StudentDto student = this.studentService.getStudentById(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/search")
    public StudentDto getStudent(
            @RequestParam(value = "id", defaultValue = "1") String id,
            @RequestParam(value = "name", defaultValue = "1") String name,
            @RequestParam(value = "email", defaultValue = "1") String email
    ) {

        // Student student = new Student(name, email, new Date());
        // studentService.addNewStudent(student);

        return this.studentService.getStudentById((long) Integer.parseInt(id));
    }


  /*  @PostMapping
    public void addNewStudent(@Valid @RequestBody StudentDto student) {
        this.studentService.addNewStudent(student);
    }*/

    @DeleteMapping(path = "{StudentID}")
    public void deleteStudent(@PathVariable("StudentID") Long id) {
        this.studentService.deleteStudent(id);
    }

    @PutMapping(path = "{StudentID}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("StudentID") Long id, @Valid @RequestBody StudentUpdateDto studentDto) {
        StudentDto studentUpdated = this.studentService.updateStudent(id, studentDto);
        return new ResponseEntity<>(studentUpdated, HttpStatus.OK);
    }
/*
    @PostMapping
    public ResponseEntity<StudentDto> addNewStudent(@Valid @RequestBody StudentDto requestStudentDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        // proccess this information with the help of the service
        StudentDto responseStudentDto = this.studentService.addNewStudent(requestStudentDto);
        return new ResponseEntity<>(responseStudentDto, HttpStatus.OK);
    }*/


    @PostMapping
    public ResponseEntity<StudentDto> improvedAddNewStudent(@Valid @RequestBody StudentDto requestStudentDto) {
        // proccess this information with the help of the service
        StudentDto responseStudentDto = this.studentService.addNewStudent(requestStudentDto);
        return new ResponseEntity<>(responseStudentDto, HttpStatus.OK);
    }


}
