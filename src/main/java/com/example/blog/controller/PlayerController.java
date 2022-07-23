package com.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayerController {
    @GetMapping("/player/joinForm")
    public String joinForm() {

        return "player/joinForm";
    }

    @GetMapping("/player/loginForm")
    public String loginForm(){

        return "player/loginForm";
    }
}
