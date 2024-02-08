package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.community.CommunityLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityLikeRepo extends JpaRepository<CommunityLikeEntity, Integer> {
    // 해당 제품에 대한 북마크의 개수를 반환하는 메서드
    int countByCommNo(int commNo);
}
