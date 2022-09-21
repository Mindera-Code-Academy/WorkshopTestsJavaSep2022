package mindera.mindswap.aveiro.module2.springboot.myfirstapi.services;

import lombok.RequiredArgsConstructor;
import mindera.mindswap.aveiro.module2.springboot.myfirstapi.command.StudentDto;
import mindera.mindswap.aveiro.module2.springboot.myfirstapi.command.StudentUpdateDto;
import mindera.mindswap.aveiro.module2.springboot.myfirstapi.converter.StudentConverter;
import mindera.mindswap.aveiro.module2.springboot.myfirstapi.persistance.models.Student;
import mindera.mindswap.aveiro.module2.springboot.myfirstapi.persistance.repositories.StudentJpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService, UserDetailsService {

    private final StudentJpaRepository studentJpaRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public StudentDto getStudentById(Long id) {

        return StudentConverter.studentToStudentDto(studentJpaRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("user not found")));
    }

    @Override
    public List<Student> getStudents() {
        //  System.out.println(imJustAComponent.getAge(20));
//        return List.of(new Student(1L,"Christophe Soares","christophe.p.soares@mindera.com", LocalDate.of(1984, Month.MARCH,31)),
//                new Student(2L,"Diogo Velho","diogo.velho@mindera.com", LocalDate.of(1985, Month.JANUARY,2)));
        return studentJpaRepository.findAll();
    }


    @Override
    public void deleteStudent(Long id) {
        //    System.out.println("id = " + id);

        studentJpaRepository.deleteById(id);
        //  this.myCollection.remove(getStudentIndex(Math.toIntExact(id)));
    }

    @Override
    public StudentDto updateStudent(Long id, StudentUpdateDto studentDto) {
      /*//  System.out.println("id = " + id + " Student=" + student);
        Student studentToUpdate = studentRepository.getStudentById(id);
        if(studentToUpdate == null) {
            return null;
        }
        Student studentUpdates = StudentConverter.studentUpdateDtoToEntity(studentDto);
        studentUpdates.setId(studentToUpdate.getId());

        studentUpdates.setPassword(
              passwordEncoder.encode(studentToUpdate.getPassword())
        );

        studentUpdates.setDateOfBirth(studentToUpdate.getDateOfBirth());

        Student updated =  studentRepository.update(studentUpdates);
        return StudentConverter.studentToStudentDto(updated);*/
        return null;
    }

    @Override
    public StudentDto addNewStudent(StudentDto studentDto) {
        // recebemos dto -> entity
        Student student = StudentConverter.dtoToStudent(studentDto);
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        // preciso de ter um id unico - JPA > SAI FORA!!
        // student.setId(singletonExample.getNext());

        // in the future store using save on the repository!
        //    studentRepository.save(student);
        Student savedStudent = studentJpaRepository.save(student);
        // return the entity -> dto
        return StudentConverter.studentToStudentDto(savedStudent);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return studentJpaRepository.findByEmail(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Username %s not found", username))
                );

    }
}
