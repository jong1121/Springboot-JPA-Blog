package com.example.blog.test;

import com.example.blog.model.RoleType;
import com.example.blog.model.User;
import com.example.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyControllerTest {

    @Autowired  //의존성 주입  DI
    private UserRepository userRepository;

    @PostMapping("/dummy/join")
    public String join(User user) {
        System.out.println("join()");
        System.out.println("username:"+user.getUsername()+" id:"+user.getId()+" password:"+user.getPassword()+" email:"+user.getEmail()+" role:"+user.getRole()
                +"create:"+ user.getCreateDate());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}
