package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TagRepo extends JpaRepository<TagEntity, Integer> {
    TagEntity findByTagName(String tagName);
}

