package com.example.blog.controller.api;

import com.example.blog.dto.ResponseDto;
import com.example.blog.model.RoleType;
import com.example.blog.model.UserM;
import com.example.blog.service.UserMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @Autowired
    private UserMService userMService;
    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody UserM userM){
        System.out.println("UserApiController.save 호출");
        userM.setRole(RoleType.USER);
        int result = userMService.회원가입(userM);
        return new ResponseDto<Integer>(HttpStatus.OK,1);
    }
}
