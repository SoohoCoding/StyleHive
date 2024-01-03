package com.codebee.stylehive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {
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
}
