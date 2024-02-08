package com.codebee.stylehive.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_info")
public class UserInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Transient
    private int userFollowsCount;
    @Transient
    private boolean isFollowing;
    @Transient
    private String loggedInUserId;

    public void setUserFollowsCount(int userFollowsCount) {
        this.userFollowsCount = userFollowsCount;
    }

    public void setIsFollowing(boolean isFollowing) {
        this.isFollowing = isFollowing;
    }

    // userId를 받는 생성자 추가
    public UserInfoEntity(String userId) {
        this.userId = userId;
    }

    @OneToMany(mappedBy = "user")
    private List<UserLikeEntity> likes;

}
