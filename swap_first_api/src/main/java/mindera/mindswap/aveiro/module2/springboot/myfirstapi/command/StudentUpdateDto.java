package mindera.mindswap.aveiro.module2.springboot.myfirstapi.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Month;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentUpdateDto {
    @NotEmpty
    @Size(min = 2, message = "user name should have at least 2 characters")
    private String name;
    @NotEmpty
    @Email
    private String email;
}
