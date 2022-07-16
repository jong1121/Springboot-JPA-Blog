package com.example.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicInsert  // insert 시 null는 파라미터 제외하여 DB의 Default 처리
public class UserM {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  //프로젝트에서 연결된 DB의 넘버링 전략을 따라감
    private int id; // 시퀀스 , auto_increment

   @Column(nullable = false, length = 30)
    private String username; //아이디

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    //@ColumnDefault("'user'")
    @Enumerated(EnumType.STRING)
    private RoleType role; // Enum을 쓰는게 좋다  enum는 도메인을 지정할 수 있다.  ADMIN, USER

    @CreationTimestamp // 시간이 자동 입력
    private Timestamp createDate;
}
