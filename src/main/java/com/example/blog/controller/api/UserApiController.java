package com.example.blog.controller.api;

import com.example.blog.dto.ResponseDto;
import com.example.blog.model.UserM;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {
    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody UserM userM){
        System.out.println("UserApiController.save 호출");
        return new ResponseDto<Integer>(HttpStatus.OK,1);
    }
}
