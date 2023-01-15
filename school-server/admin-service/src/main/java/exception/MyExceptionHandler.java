package exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorType> handle(Exception e){
        ErrorType errorType = new ErrorType();
        errorType.setError("Something went wrong !");
        errorType.setCode("404");
        errorType.setStatus("asda");
        errorType.setMessage(e.getMessage());
        return new ResponseEntity<ErrorType>(errorType, HttpStatus.NOT_ACCEPTABLE);
    }
}
