package com.example.blog.config.auth;

import com.example.blog.model.Player;
import com.example.blog.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
    private PlayerRepository playerRepository;


    /*
        스프링이 로그인 요청 가로 챌 때 playername, password 변수 2개를 가로 채는데
        password 부분처리는 알아서 하나
        playername 이 DB에 있는지만 확인해주시면 됨
         */
    @Override  // loadUserByUsername 는 post form 의 username를 가진 name만 가져옴
    public UserDetails loadUserByUsername(String playername) throws UsernameNotFoundException{
        System.out.println("PrincipalDetailService:loadUserByUsername 호출");
        System.out.println("playername:"+playername);
        Player principal = playerRepository.findByPlayername(playername)
                .orElseThrow(()->{
                    return new UsernameNotFoundException("해당 플레이어를 찾을 수 없습니다:"+playername);
                });
        return new PrincipalDetail(principal);  // 시큐리티 세션에 유저 정보 저장
    }
}
