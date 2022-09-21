package mindera.mindswap.aveiro.module2.springboot.myfirstapi.config;

import mindera.mindswap.aveiro.module2.springboot.myfirstapi.persistance.models.Student;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeansInit {

    @Bean
    public List<Student> myCollection() {
        return new ArrayList<>();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
