package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserInfoRepo extends JpaRepository<UserInfoEntity, String> {
    List<UserInfoEntity> findByUserNameContainingOrUserNicknameContainingOrUserIntroduceContaining(String userName, String userNickname, String userIntroduce);
}