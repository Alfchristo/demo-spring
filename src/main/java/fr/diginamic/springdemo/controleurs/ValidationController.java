package fr.diginamic.springdemo.controleurs;

import fr.diginamic.springdemo.exception.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ValidationController {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(ValidationException exception) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Ville existe déja", exception.getMessage());
        return ResponseEntity.badRequest().body(errors);
    }
}
