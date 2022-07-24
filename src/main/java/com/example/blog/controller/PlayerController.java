package com.example.blog.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 인증이 안된 사용자들이 출입할 수 있는 경로를 /auth/** 허용
 그냥 주소가 / 이면 index.jsp 허용
 static 이하에 있는 리소스 파일(js,css,image) 허용
 */
@Log4j2
@Controller
public class PlayerController {
    @GetMapping("/auth/joinForm")
    public String joinForm() {

        return "player/joinForm";
    }

    @GetMapping("/auth/loginForm")
    public String loginForm() throws Exception {

        return "player/loginForm";
    }
}
