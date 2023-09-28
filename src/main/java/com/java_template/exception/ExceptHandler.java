package com.java_template.exception;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class ExceptHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(@NotNull MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<String> handleInvalidFormatException(@org.jetbrains.annotations.NotNull InvalidFormatException ex) {
        String errorMessage = "O campo '" + ex.getPath().get(0).getFieldName() + "' deve ser um número inteiro válido.";
        return ResponseEntity.badRequest().body(errorMessage);
    }
}