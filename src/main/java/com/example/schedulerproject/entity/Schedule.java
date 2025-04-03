package com.example.schedulerproject.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table (name = "Schedule")
public class Schedule extends BaseEntity {

//    **필드**
    // ID 자동생성 , PK 지정하기
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 할일 제목
    @Column(nullable = false)
    private String title;

    // 할일 내용
    @Column(columnDefinition = "longtext")
    private String description;

    // 테이블 연결
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    **생성자**
    // 기본 생성자
    public Schedule() {
    }

    // 일정 생성자
    public Schedule(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // 작성한 유저 이름 붙이기
    public void setUser(User user) {
        this.user = user;
    }
}
