package com.example.blog.handler;

import com.example.blog.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = Exception.class)
    public ResponseDto<String> handleException(Exception e) {

        System.out.println("GlobalException:"+e.getMessage());
         return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}
