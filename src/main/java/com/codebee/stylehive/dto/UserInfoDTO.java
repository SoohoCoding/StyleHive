package com.codebee.stylehive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("user")
public class UserInfoDTO {
    String userId;
    String userName;
    String userNickname;
    String userIntroduce;
    String userEmail;
    String userPhoneNum;
    int userSsn;
    String userImg;
    int userPoint;
    String userAddress;
    int userCalculate;
    int userSnsLogin;
    int userRole;
    boolean userPrivate;
    boolean userState;
    boolean userInformation;

    List<CommunityDTO> commList = new ArrayList<>();
    int followCount;
    int followedCount;
    int communityCount;
    int productCount;
}
