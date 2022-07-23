package com.example.blog.service;

import com.example.blog.model.Player;
import com.example.blog.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 스프링 컴포넌트 스캔 통해 빈 등록 IoC
@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Transactional
    public int 회원가입(Player player) {

        try {
            playerRepository.save(player);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("PlayerService=>" + e.getMessage());
        }

        return -1;

    }

    @Transactional(readOnly = true)  // Select할 때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료(정합성)
    public Player 로그인(Player player) {
       return playerRepository.login(player.getPlayername(),player.getPassword());
    }
}
