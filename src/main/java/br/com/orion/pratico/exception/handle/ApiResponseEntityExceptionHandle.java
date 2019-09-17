package br.com.orion.pratico.exception.handle;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.orion.pratico.exception.ResourceNotFoundException;
import br.com.orion.pratico.exception.detail.ErrorDetail;
import br.com.orion.pratico.exception.detail.ValidationErrorDetail;

@ControllerAdvice
public class ApiResponseEntityExceptionHandle extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception) {
        ErrorDetail errorDetail = ErrorDetail.Builder.newBuilder()
        .statusCode(HttpStatus.NOT_FOUND.value())
        .message(exception.getMessage())
        .timestamp(LocalDateTime.now())
        .build();

        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(fe -> errors.put(fe.getField(), fe.getDefaultMessage()));
                
        ValidationErrorDetail errorDetail = ValidationErrorDetail.Builder.newBuilder()
        .statusCode(HttpStatus.NOT_FOUND.value())
        .message(exception.getMessage())
        .errors(errors)
        .build();
        
        return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
    }
    
}