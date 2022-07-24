package com.example.blog.controller;

import com.example.blog.config.auth.PrincipalDetail;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class BoardController {

    @GetMapping("/")
    public String index(@AuthenticationPrincipal PrincipalDetail principalDetail){

        // /WEB-INF/views/index.jsp
        System.out.println("로그인 사용자 아이디 :"+ principalDetail.getUsername());
        return "index";
    }
}
