package com.example.blog.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class BoardController {

    @GetMapping("/")
    public String index(){
        // /WEB-INF/views/index.jsp
        return "index";
    }
}
