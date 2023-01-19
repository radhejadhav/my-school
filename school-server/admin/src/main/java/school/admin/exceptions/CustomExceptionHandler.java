package school.admin.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import school.admin.dto.ResponseHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.BAD_GATEWAY)
    public ResponseEntity<Object> handleCustomException(RuntimeException e){

        return ResponseHandler.generateResponse(
                "Exception",
                "Error",
                HttpStatus.BAD_GATEWAY,
                new CustomError(
                        e.getMessage(),
                        HttpStatus.BAD_GATEWAY.value(),
                        HttpStatus.BAD_GATEWAY.toString(),
                        e.toString()
                )
        );
    }

    public CustomExceptionHandler() {
        super();
    }

}
