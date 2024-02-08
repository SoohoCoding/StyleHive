package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.UserFollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFollowRepo extends JpaRepository<UserFollowEntity, String> {
    // 팔로워 숫자
    int countByUserId2(String userId);

    // 팔로우 여부
    boolean existsByUserIdAndUserId2(String userId, String userId2);

    // 팔로우 취소
    void deleteByUserIdAndUserId2(String userId, String userId2);
}
