//package school.admin.exceptions;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//@RestControllerAdvice
//public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(value = HttpStatus.BAD_GATEWAY)
//    public ResponseEntity<CustomError> handleCustomException(Exception e){
//
//        return new ResponseEntity<CustomError>(
//                new CustomError(
//                        e.getMessage(),
//                        HttpStatus.BAD_REQUEST.toString(),
//                        "Not Found",
//                        "Error"),
//                HttpStatus.BAD_REQUEST);
//    }
//
//    public CustomExceptionHandler() {
//        super();
//    }
//
//}
