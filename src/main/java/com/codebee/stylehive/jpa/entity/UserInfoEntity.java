package com.codebee.stylehive.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_info")
public class UserInfoEntity {
    @Id
    private String userId;
    private String userPass;
    private String userName;
    private String userNickname;
    private String userIntroduce;
    private String userEmail;
    private String userPhoneNum;
    private int userSsn;
    private String userImg;
    private Integer userPoint;
    private String userAddress;
    private Integer userCalculate;
    private Integer userSnsLogin;
    private int userRole;
    private boolean userPrivate;
    private boolean userState;
    private boolean userInformation;

    // userId를 받는 생성자 추가
    public UserInfoEntity(String userId) {
        this.userId = userId;
    }
}
