package com.example.blog.service;

import com.example.blog.model.Board;
import com.example.blog.model.Player;
import com.example.blog.model.RoleType;
import com.example.blog.repository.BoardRepository;
import com.example.blog.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional(readOnly = true)
    public Board 글상세보기(int id){
        return boardRepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("해당 글을 찾을 수 없습니다.");
                });
    }
    @Transactional(readOnly = true)
    public Page<Board> 글목록(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    @Transactional
    public void 글삭제하기(int id){
     boardRepository.deleteById(id);
     return;
    }
}
