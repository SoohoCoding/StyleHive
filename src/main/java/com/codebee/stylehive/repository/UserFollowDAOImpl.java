package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.UserFollowEntity;
import com.codebee.stylehive.jpa.repository.*;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@NoArgsConstructor
public class UserFollowDAOImpl implements UserFollowDAO {
    UserFollowRepo userFollowRepo;

    @Autowired
    public UserFollowDAOImpl(UserFollowRepo userFollowRepo) {
        this.userFollowRepo = userFollowRepo;
    };

    private String getCurrentUserId() {
        // 여기에서 세션 정보나 사용자 인증을 통해 현재 사용자의 user_id를 얻어온다고 가정합니다.
        // 예를 들어 Spring Security를 사용한다면 SecurityContextHolder를 통해 Principal을 가져올 수 있습니다.
        // 이 예시에서는 간단히 "admin"라는 문자열을 반환합니다.
        return "admin";
    }

    @Override
    public void follow(String userId2) {
        // 현재 사용자의 user_id를 얻어옵니다.
        String currentUserId = getCurrentUserId();

        if (!userFollowRepo.existsByUserIdAndUserId2(currentUserId, userId2)) {
            System.out.println("add"+currentUserId);
            userFollowRepo.save(new UserFollowEntity(currentUserId, userId2));
        } else {
            System.out.println("delete"+currentUserId);
            userFollowRepo.deleteByUserIdAndUserId2(currentUserId, userId2);
        }
    }
}
