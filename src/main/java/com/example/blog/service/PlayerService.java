package com.example.blog.service;

import com.example.blog.model.Player;
import com.example.blog.model.RoleType;
import com.example.blog.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 스프링 컴포넌트 스캔 통해 빈 등록 IoC
@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private BCryptPasswordEncoder encode;

    @Transactional
    public void 회원가입(Player player) {
            String rawPassword = player.getPassword();
            String encPassword = encode.encode(rawPassword);
            player.setPassword(encPassword);
            player.setRole(RoleType.PLAYER);
            playerRepository.save(player);

    }
}
