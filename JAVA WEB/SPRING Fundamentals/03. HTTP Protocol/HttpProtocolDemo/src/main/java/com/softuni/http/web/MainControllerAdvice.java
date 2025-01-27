package com.softuni.http.web;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MainControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ProblemDetail entityNotFoundException() {

        return ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
    }
}
