package mindera.mindswap.aveiro.module2.springboot.myfirstapi.exception;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AppError {
    private String message;
    private String verb;
    private String path;
    private Date timestamp;
    private String statusCode;
}
