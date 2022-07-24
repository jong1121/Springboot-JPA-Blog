package com.example.blog.config;

import com.example.blog.config.auth.PrincipalDetail;
import com.example.blog.config.auth.PrincipalDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration // IoC
@EnableWebSecurity  // 필터 적용
@EnableGlobalMethodSecurity(prePostEnabled = true)  // 특정주소 접근하면 권한 인증 미리 체크
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PrincipalDetailService principalDetailService;
    @Bean // IoC
    public BCryptPasswordEncoder encodePWD(){
        System.out.println("SecurityConfig:encodePWD() 호출");
        return new BCryptPasswordEncoder();
    }

    /*
    시큐리티가 대신 로그인해주는데 password를 가로채기를 하는데
    해당 password가 뭘로 해쉬가 되어 회원가입 되었는지 알아야
    같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교할 수 있음
     */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("SecurityConfig:configure1 호출");
        auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
        super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        System.out.println("SecurityConfig:configure2 호출");
        http
            .csrf().disable()  // csrf 토큰 비활성화
            .authorizeRequests()
            .antMatchers("/auth/**","/js/**","/css/**","/image/**")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage("/auth/loginForm")
            .loginProcessingUrl("/auth/loginProc")  // spring security 가 해당 주소 요청 로그인 가로채서 대신 로그인
            .defaultSuccessUrl("/")
            .failureUrl("/failED")

        ;
    }
}
