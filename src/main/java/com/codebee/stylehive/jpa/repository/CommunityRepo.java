package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.CommunityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityRepo extends JpaRepository<CommunityEntity, Integer> {
    List<CommunityEntity> findByCommNoIn(List<Integer> commNos);
    List<CommunityEntity> findByCommTitleContainingOrCommContentsContaining(String keyword1, String keyword2);
}
