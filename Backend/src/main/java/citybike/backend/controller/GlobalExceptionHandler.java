package citybike.backend.controller;


import citybike.backend.exceptions.InvalidStationNameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Exception Handling for the case someone is typing an incorrect station-url.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidStationNameException.class)
    public ResponseEntity<String> handleInvalidStationNameException(InvalidStationNameException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
