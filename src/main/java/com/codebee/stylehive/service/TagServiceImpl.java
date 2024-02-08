package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.TagEntity;
import com.codebee.stylehive.repository.TagDAO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class TagServiceImpl implements TagService{

    TagDAO dao;

    @Autowired
    public TagServiceImpl(TagDAO dao) {
        this.dao = dao;
    }

    @Override
    public TagEntity findById(int id) {
        return dao.findById(id);
    }


}
