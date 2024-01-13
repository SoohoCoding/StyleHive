package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.TagEntity;

public interface TagService{
    public TagEntity findById(int id);

}