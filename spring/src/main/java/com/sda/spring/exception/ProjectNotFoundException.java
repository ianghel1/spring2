package com.sda.spring.exception;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException(String message){
        super(message);
    }
}
