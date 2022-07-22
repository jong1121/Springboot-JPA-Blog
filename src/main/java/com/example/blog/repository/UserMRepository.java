package com.example.blog.repository;

import com.example.blog.model.UserM;
import org.springframework.data.jpa.repository.JpaRepository;

// DAO
// 자동 빈 등록 되므로 Repository 어노테이션 생략 가능
public interface UserMRepository  extends JpaRepository<UserM,  Integer> {

}
