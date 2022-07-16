package com.example.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // auto_increment
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob // 대용량 데이터
    private String content;   //섬머노트 라이브러리  html tag

    @ColumnDefault("0")
    private int count;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name="userId")
    private UserM userM; //DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.

    @OneToMany (mappedBy = "board", fetch = FetchType.EAGER) //연관관계의 주인이 아니다
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;
}
