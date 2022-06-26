package com.example.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Controller
public class TempControllerTest {


    @GetMapping("/temp/jsp")
    public String tempJsp() {
        System.out.println("tempJsp()");
        return "test";

    }




}
