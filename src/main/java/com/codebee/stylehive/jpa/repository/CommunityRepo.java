package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.community.CommunityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepo extends JpaRepository<CommunityEntity, Integer> {

}
