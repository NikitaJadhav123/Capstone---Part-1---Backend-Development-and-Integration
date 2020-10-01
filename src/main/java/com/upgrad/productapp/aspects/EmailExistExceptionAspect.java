package com.upgrad.productapp.aspects;

import com.upgrad.productapp.exceptions.EmailExistsException;
import com.upgrad.productapp.responses.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmailExistExceptionAspect {
    @ExceptionHandler(EmailExistsException.class)
    public ResponseEntity<CustomResponse> handleAPIException(Exception e){
        CustomResponse response = new CustomResponse(e.getMessage(), HttpStatus.EXPECTATION_FAILED.value());
        return  new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }
}
