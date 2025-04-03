package com.example.schedulerproject.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user")
public class User extends BaseEntity {

//    **필드**
    // ID 자동생성 , PK 지정하기
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 유저명
    @Column(nullable = false)
    private String username;

    // 유저 이메일
    @Column(nullable = false)
    private String mail;

    // 유저 비밀번호
    @Column(nullable = false)
    private String password;

//    ** 생성자**
    public User() {
    }

    public User(String username, String mail, String password) {
        this.username = username;
        this.mail = mail;
        this.password = password;
    }

//    **메서드**
    // 유저 비밀번호 수정
    public void updatePassword(String password) {
        this.password = password;
    }

}
