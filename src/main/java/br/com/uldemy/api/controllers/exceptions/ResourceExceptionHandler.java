package br.com.uldemy.api.controllers.exceptions;

import br.com.uldemy.api.service.exceptions.DataIntegrityViolationException;
import br.com.uldemy.api.service.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request){
        StandartError error =
                new StandartError(
                        LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
                        ex.getMessage(), request.getRequestURI()
                );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandartError> dataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest request){
        StandartError error =
                new StandartError(
                        LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
                        ex.getMessage(), request.getRequestURI()
                );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
