package mindera.mindswap.aveiro.module2.springboot.myfirstapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@RestController
public class MyFirstApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(MyFirstApiApplication.class, args);
    }

//    @GetMapping
//    public String hello(){
//        return "Hello World!";
//    }

//    @GetMapping
//    public List<String> hello(){
//        return List.of("Hello", "world", "!");
//    }

//    @GetMapping
//    public List<Student> hello(){
//        return List.of(new Student(1L,"Christophe Soares","christophe.p.soares@mindera.com", LocalDate.of(1984, Month.MARCH,31)),
//                new Student(2L,"Diogo Velho","diogo.velho@mindera.com", LocalDate.of(1985, Month.JANUARY,2)));
//    }
}
