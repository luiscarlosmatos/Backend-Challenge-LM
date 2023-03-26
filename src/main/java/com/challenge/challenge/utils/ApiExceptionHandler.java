package com.challenge.challenge.utils;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.management.BadAttributeValueExpException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            EntityNotFoundException ex) {

        ApiErrorDTO build = ApiErrorDTO.builder()
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();
        return ResponseEntity.status(build.getStatus()).body(build);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<Object> handleIllegalArgumentException(
            IllegalArgumentException ex) {

        ApiErrorDTO build = ApiErrorDTO.builder()
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return ResponseEntity.status(build.getStatus()).body(build);
    }

}
