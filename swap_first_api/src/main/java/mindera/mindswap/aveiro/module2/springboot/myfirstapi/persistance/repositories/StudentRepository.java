package mindera.mindswap.aveiro.module2.springboot.myfirstapi.persistance.repositories;

import mindera.mindswap.aveiro.module2.springboot.myfirstapi.persistance.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    private final List<Student> myCollection;

    @Autowired
    public StudentRepository(List<Student> myCollection) {
        this.myCollection = myCollection;
    }

    public List<Student> getAllStudents() {
        return myCollection;
    }

    public Student getStudentById(Long id) {
        //  try {
        return myCollection.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
        //   } catch (IndexOutOfBoundsException e) {
        //       return null;
        //   }
    }

    public Student save(Student student) {
        myCollection.add(student);
        return student;
    }


    public Student update(Student studentToUpdate) {
        Student student = getStudentById(studentToUpdate.getId());
        if (student == null) {
            return null;
        }
        student.setName(studentToUpdate.getName());
        student.setEmail(studentToUpdate.getEmail());
        myCollection.set(myCollection.indexOf(student), student);
        return student;
    }

    public void delete(Long id) {
        myCollection.remove(Math.toIntExact(id));
    }
}
