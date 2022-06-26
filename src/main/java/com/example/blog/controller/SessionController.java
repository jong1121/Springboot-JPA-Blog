package com.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

@Controller
public class SessionController {

    @GetMapping("/Session/main.do")
    public ModelAndView main(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/Session/main");
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        mv.addObject("sessionId",sessionId);
        List <HashMap<String,String>> resultList  = new ArrayList<>();
        HashMap<String,String> resultMap ;
        Enumeration<String> sessionNames = session.getAttributeNames();
        while(sessionNames.hasMoreElements()){
            resultMap = new HashMap<>();
            String sessionKey = sessionNames.nextElement();
            Object data = session.getAttribute(sessionKey);
            resultMap.put("sessionKey",sessionKey);
            resultMap.put("data",(String) data);
            resultList.add(resultMap);
        }
        mv.addObject("resultList",resultList);
        return mv;
    }

    @ResponseBody
    @PostMapping("/Session/addData.do")
    public String addData(HttpServletRequest request
            , @RequestBody HashMap<String, String> hm){
        request.getSession().setAttribute(hm.get("key"), hm.get("value"));
        return "addData OK!!";
    }

    @ResponseBody
    @PostMapping("/Session/deleteData.do")
    public String deleteData(HttpServletRequest request
            , @RequestBody HashMap<String, String> hm){
        request.getSession().removeAttribute(hm.get("key"));
        return "deleteData OK!!";
    }

    @ResponseBody
    @PostMapping("/Session/removeSession.do")
    public String removeSession(HttpServletRequest request
            , @RequestBody HashMap<String, String> hm){
        request.getSession().invalidate();
        return "removeSession OK!!";
    }
}
