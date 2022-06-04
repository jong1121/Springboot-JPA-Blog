package com.example.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {

    @GetMapping("/temp/home")
    public String tempHome() {
        System.out.println("tempHome()");
        return "/home.html";
    }

    @GetMapping("/temp/jpg")
    public String tempPng() {
        System.out.println("tempPng()");
        return "/1.png";
    }

    @GetMapping("/temp/jsp")
    public String tempJsp() {
        System.out.println("tempJsp()");
        return "test";

    }



}
