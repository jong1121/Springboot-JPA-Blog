package com.example.blog.controller.api;

import com.example.blog.dto.ResponseDto;
import com.example.blog.model.Player;
import com.example.blog.model.RoleType;
import com.example.blog.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class PlayerApiController {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private HttpSession session;

    @PostMapping("/api/player")
    public ResponseDto<Integer> save(@RequestBody Player player) {

        player.setRole(RoleType.PLAYER);
        int result = playerService.회원가입(player);
        return new ResponseDto<Integer>(HttpStatus.OK, result);


    }

    @PostMapping("/api/player/login")
    public ResponseDto<Integer> login(@RequestBody Player player)  {
        int result = -1;
        Player principal = playerService.로그인(player);  // 접근주체
        if ( principal != null){
            session.setAttribute("principal",principal);
            result = 1;
        }
        return new ResponseDto<Integer>(HttpStatus.OK,result);
    }

}
