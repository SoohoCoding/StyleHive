package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.community.CommunityCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityCommentRepo extends JpaRepository<CommunityCommentEntity, Integer> {
}
