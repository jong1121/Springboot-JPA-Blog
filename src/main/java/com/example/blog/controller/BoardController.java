package com.example.blog.controller;

import com.example.blog.config.auth.PrincipalDetail;
import com.example.blog.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Log4j2
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public String index(@AuthenticationPrincipal PrincipalDetail principalDetail
                        , Model model
                        , @PageableDefault(size = 3, sort="id", direction = Sort.Direction.DESC) Pageable pageable){

        model.addAttribute("boards",boardService.글목록(pageable));
        // /WEB-INF/views/index.jsp
        System.out.println("로그인 사용자 아이디 :"+ principalDetail.getUsername());
        return "index";
    }

    @GetMapping("/board/{id}")
    public String findById(@PathVariable int id,Model model){
        model.addAttribute("board", boardService.글상세보기(id));
        return "/board/detail";
    }

    //User 권한이 필요
    @GetMapping ("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }
}
