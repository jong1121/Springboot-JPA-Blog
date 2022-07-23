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
            System.out.println("PlayerService:회원가입():" + e.getMessage());
        }

        return -1;

    }
}
