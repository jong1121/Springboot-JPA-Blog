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

@RestController
public class PlayerApiController {

    @Autowired
    private PlayerService playerService;
    @PostMapping("/api/player")
    public ResponseDto<Integer> save(@RequestBody Player player){
        System.out.println("PlayerApiController.save 호출");
        player.setRole(RoleType.PLAYER);
        int result = playerService.회원가입(player);
        return new ResponseDto<Integer>(HttpStatus.OK,1);
    }
}
