package mindera.mindswap.aveiro.module2.springboot.myfirstapi.converter;

import mindera.mindswap.aveiro.module2.springboot.myfirstapi.command.StudentDto;
import mindera.mindswap.aveiro.module2.springboot.myfirstapi.command.StudentUpdateDto;
import mindera.mindswap.aveiro.module2.springboot.myfirstapi.persistance.models.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

public class StudentConverter implements Converter<Student, StudentDto> {


    private final static ModelMapper modelMapper = new ModelMapper();
    // response
    public static StudentDto studentToStudentDto(Student student) {
        return modelMapper.map(student, StudentDto.class);
    /*
        StudentDto studentDto1 = StudentDto.builder()
                .email(student.getEmail())
                .name(student.getName())
                .id(student.getId())
                .build();
        return studentDto1;*/
    }

    // request
    public static Student dtoToStudent(StudentDto studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setPassword(studentDTO.getPassword());
        student.setDateOfBirth(studentDTO.getDateOfBirth());
        return student;
    }

    public static StudentUpdateDto entityToStudentUpdateDto(Student student) {
        return modelMapper.map(student, StudentUpdateDto.class);

    }
    public static Student studentUpdateDtoToEntity(StudentUpdateDto studentUpdateDto) {
        return modelMapper.map(studentUpdateDto, Student.class);
    }

    @Override
    public StudentDto convertToDto(Student student) {
        return null;
    }

    @Override
    public Student convertFromDto(StudentDto studentDto) {
        return null;
    }
}
