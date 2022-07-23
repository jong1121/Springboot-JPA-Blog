package com.example.blog.repository;

import com.example.blog.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// DAO
// 자동 빈 등록 되므로 Repository 어노테이션 생략 가능
public interface PlayerRepository extends JpaRepository<Player,  Integer> {
    /*
    //JPA Naming 전략 -> findByPlayernameAndPassword 를 네이밍하면 아래 쿼리로 동작하여 호출
    // SELECT * FROM Player WHERE playername = ? AND password = ? ;
    Player findByPlayernameAndPassword(String playername, String password);
    */
    @Query(value="SELECT * FROM Player WHERE Playername =?1 AND password = ?2", nativeQuery = true)
    Player login(String playername, String password);
}
