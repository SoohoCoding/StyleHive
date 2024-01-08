package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.TagEntity;

public interface TagDAO {
    public TagEntity findById(int id);
}
