package mindera.mindswap.aveiro.module2.springboot.myfirstapi.persistance.repositories;

import mindera.mindswap.aveiro.module2.springboot.myfirstapi.persistance.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentJpaRepository extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);
    Optional<Student> findByEmail(String email);

    Optional<Student> findByNameAndEmail(String name, String email);


}

