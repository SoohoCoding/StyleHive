package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepo extends JpaRepository<TagEntity,Integer> {
}
