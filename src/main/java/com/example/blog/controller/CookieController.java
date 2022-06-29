package com.example.blog.controller;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@Controller
public class CookieController {



    @GetMapping("/Cookie/main.do")
    public  ModelAndView main(HttpServletResponse response){
        log.info("/Cookie/main.do");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/Cookie/main");
        return  mv;
    }
    @GetMapping("/Cookie/put.do")
    public String put(HttpServletResponse response){
        log.info("/Cookie/put.do");
        Cookie cookie = new Cookie("usermail","blueskii");
        cookie.setDomain("localhost");
        cookie.setPath("/");
        cookie.setMaxAge(30*60); // 30분 저장
        cookie.setSecure(true);
        response.addCookie(cookie);
        return "/Cookie/main";
    }

    @GetMapping("/Cookie/get.do")
    public String getCookie2(HttpServletRequest request){
        log.info("/Cookie/get.do");
        Cookie [] list = request.getCookies();
        for(Cookie cookie:list){
            log.info(cookie.getName()+":"+cookie.getValue());
        }
        return "/Cookie/main";
    }


}
