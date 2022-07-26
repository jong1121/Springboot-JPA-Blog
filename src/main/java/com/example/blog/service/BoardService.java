package com.example.blog.service;

import com.example.blog.model.Board;
import com.example.blog.model.Player;
import com.example.blog.model.RoleType;
import com.example.blog.repository.BoardRepository;
import com.example.blog.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 스프링 컴포넌트 스캔 통해 빈 등록 IoC
@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;


    @Transactional
    public void 글쓰기(Board board,Player player) {  //title, content
        board.setCount(0);
        board.setPlayer(player);
        boardRepository.save(board);
    }
}
