package com.example.blog.test;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Member {

    private int id ;
    private String playername;
    private String password;
    private String email;

}
