package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.TagEntity;
import com.codebee.stylehive.jpa.repository.TagRepo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@NoArgsConstructor
public class TagDAOImpl implements TagDAO{
    TagRepo repo;
    @Autowired
    public TagDAOImpl(TagRepo repo) {
        this.repo = repo;
    }

    @Override
    public TagEntity findById(int id) {
        return this.repo.findById(id).get();
    }
}
