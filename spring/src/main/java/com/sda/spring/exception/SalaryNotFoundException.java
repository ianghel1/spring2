package com.sda.spring.exception;

public class SalaryNotFoundException  extends RuntimeException {

    public SalaryNotFoundException(String message) {
        super(message);
    }
}
