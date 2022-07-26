package com.example.blog.controller.api;

import com.example.blog.config.auth.PrincipalDetail;
import com.example.blog.dto.ResponseDto;
import com.example.blog.model.Board;
import com.example.blog.model.Player;
import com.example.blog.service.BoardService;
import com.example.blog.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardApiController {


    @Autowired
    private BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) {
        //System.out.println(board.getContent());
        boardService.글쓰기(board , principal.getPlayer());
        return new ResponseDto<Integer>(HttpStatus.OK, 1);


    }



}
