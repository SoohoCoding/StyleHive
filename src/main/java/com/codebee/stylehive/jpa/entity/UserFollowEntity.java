package com.codebee.stylehive.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_follow")
public class UserFollowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int followNo;
    private String userId;
    private String userId2;

    // 생성자 추가
    public UserFollowEntity(String userId, String userId2) {
        this.userId = userId;
        this.userId2 = userId2;
    }
}