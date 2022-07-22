package com.example.blog.service;

import com.example.blog.model.UserM;
import com.example.blog.repository.UserMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 스프링 컴포넌트 스캔 통해 빈 등록 IoC
@Service
public class UserMService {
    @Autowired
    private UserMRepository userMRepository;

    @Transactional
    public int 회원가입(UserM userM) {

        try {
            userMRepository.save(userM);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UserService:회원가입():" + e.getMessage());
        }

        return -1;

    }
}
