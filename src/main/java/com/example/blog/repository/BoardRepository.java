package com.example.blog.repository;

import com.example.blog.model.Board;
import com.example.blog.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// DAO
// 자동 빈 등록 되므로 Repository 어노테이션 생략 가능
public interface BoardRepository extends JpaRepository<Board,  Integer> {




}
