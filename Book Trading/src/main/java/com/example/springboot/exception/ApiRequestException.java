package com.example.springboot.exception;

public class ApiRequestException extends  RuntimeException{

    public ApiRequestException(String message){
        super(message);
    }

}
