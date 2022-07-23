package com.example.blog.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Log4j2
@Controller
public class PlayerController {
    @GetMapping("/player/joinForm")
    public String joinForm() {

        return "player/joinForm";
    }

    @GetMapping("/player/loginForm")
    public String loginForm() throws Exception {

        return "player/loginForm";
    }
}
