package com.example.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

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

    @GetMapping ("/temp/session")
    public String tempSession(HttpServletRequest request) {
        System.out.println("tempSession");
        HttpSession session = request.getSession();
        session.setAttribute("name1","test1");
        String name1 = session.getAttribute("name1").toString();
        if(name1 == null ){
            System.out.println("name1 값이 없습니다.");

        }
        else {
            System.out.println("name1:"+name1);
        }
        // 세션 데이터 전부 가져오기
        Enumeration<String> sessionNames = session.getAttributeNames();
        while(sessionNames.hasMoreElements()){
            String sessionKey = sessionNames.nextElement();
            Object data = session.getAttribute(sessionKey);
            System.out.println(sessionKey+":"+(String) data);
        }

        System.out.println(request.getContextPath());
        System.out.println(request.getSession().getId());
        return "session";
    }



}
