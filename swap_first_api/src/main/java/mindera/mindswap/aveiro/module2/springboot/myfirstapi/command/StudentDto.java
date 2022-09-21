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
@EqualsAndHashCode
public class StudentDto {

    private long id;
    private LocalDate dateOfBirth = LocalDate.of(2000, Month.MARCH, 1);
    @NotEmpty
    @Size(min = 2, message = "user name should have at least 2 characters")
    private String name;
    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 8, message = "the password should have at least 8 characters!")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

}
