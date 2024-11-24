package com.msn.productservice.advices;

import com.msn.productservice.dtos.ErrorDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDto> handleNPEException(){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Something went wrong");
        ResponseEntity<ErrorDto> responseEntity = new ResponseEntity<>(errorDto, HttpStatusCode.valueOf(500));

        return responseEntity;
    }
}
