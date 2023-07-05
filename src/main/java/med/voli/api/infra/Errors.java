package med.voli.api.infra;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class Errors {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleNotFound() {
        Map<String, Object> responseBodyError = new HashMap<>();
        responseBodyError.put("message", "Doctor not found");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBodyError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DataErrorValidation>> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        var errors = exception.getFieldErrors();
        var responseError = ResponseEntity.badRequest().body(errors.stream().map(DataErrorValidation::new).toList());
        return responseError;
    }

    private record DataErrorValidation(String field, String message) {
        public DataErrorValidation(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
    
}
