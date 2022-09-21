package mindera.mindswap.aveiro.module2.springboot.myfirstapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = {UsernameNotFoundException.class})
    public ResponseEntity<AppError> dealWithUserNotExists(Exception e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(buildError(e, request, HttpStatus.NOT_FOUND.toString()));
    }

    private AppError buildError(Exception e, HttpServletRequest request, String statusCode) {
        return AppError.builder()
                .timestamp(new Date())
                .verb(request.getMethod())
                .path(request.getRequestURI())
                .statusCode(statusCode)
                .message(e.getMessage())
                .build();
    }
}
