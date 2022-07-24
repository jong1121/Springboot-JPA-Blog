package com.example.blog.config.auth;

import com.example.blog.model.Player;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

// 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 UserDetails 타입의 오브젝트를
// 스프링 시큐리티의 고유한 세션저장소에 저장을 해준다.
public class PrincipalDetail implements UserDetails {
    private Player player;  //컴포지션

    public PrincipalDetail(Player player){
        System.out.println("PrincipalDetail:PrincipalDetail 생성 호출");
    this.player = player;
    }

    @Override
    public String getPassword() {
        System.out.println("PrincipalDetail:getPassword() 호출");
        return player.getPassword();
    }

    @Override
    public String getUsername() {
        System.out.println("PrincipalDetail:getUsername() 호출");
        return player.getPlayername();
    }

    // 계정이 만료되지 않았는지 리턴한다. (true : 만료안됨)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    // 계정이 잠겨있지 않았는지 리턴 ( true : 잠기지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    // 비밀번호가 만료되지 않았는지 리턴 (true: 만료아님)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    // 계정 활성화 여부
    @Override
    public boolean isEnabled() {
        return true;
    }
    // 계정의 소유한 권한 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collectors = new ArrayList<>();

        /*
        collectors.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_"+player.getRole();  // ROLE_USER 스프링 패턴 prefix 필수
            }
        });
        */
        collectors.add(() -> {return "ROLE_"+player.getRole();});
        return collectors;
    }

}
