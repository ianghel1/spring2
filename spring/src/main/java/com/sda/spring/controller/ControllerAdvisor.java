package com.sda.spring.controller;

import com.sda.spring.exception.CompanyNotFoundException;
import com.sda.spring.exception.EmployeeNotFoundException;
import com.sda.spring.exception.ProjectNotFoundException;
import com.sda.spring.exception.SalaryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException exception){

        Map<String, Object> body  = new LinkedHashMap<>();
        body.put("Timestamp: ", LocalDateTime.now());
        body.put("Message:", exception.getLocalizedMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<Object> handleCompanyNotFoundException(CompanyNotFoundException exception){
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("Timestamp: ", LocalDateTime.now());
    body.put("Message: ", exception.getLocalizedMessage());

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<Object> handleProjectNotFoundException(ProjectNotFoundException exception){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("Timestamp: ", LocalDateTime.now());
        body.put("Message: ", exception.getLocalizedMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SalaryNotFoundException.class)
    public ResponseEntity<Object> handleSalayNotFoundException(SalaryNotFoundException exception){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("Timestamp: ", LocalDateTime.now());
        body.put("Message: ", exception.getLocalizedMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
