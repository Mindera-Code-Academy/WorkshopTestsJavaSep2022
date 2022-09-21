package mindera.mindswap.aveiro.module2.springboot.myfirstapi.services;

import mindera.mindswap.aveiro.module2.springboot.myfirstapi.command.StudentDto;
import mindera.mindswap.aveiro.module2.springboot.myfirstapi.command.StudentUpdateDto;
import mindera.mindswap.aveiro.module2.springboot.myfirstapi.persistance.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();

    StudentDto getStudentById(Long id);

    void deleteStudent(Long id);

    StudentDto updateStudent(Long id, StudentUpdateDto studentDto);

    StudentDto addNewStudent(StudentDto studentDto);
}
