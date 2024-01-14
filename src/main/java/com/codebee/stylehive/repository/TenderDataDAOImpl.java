package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.TenderDataEntity;
import com.codebee.stylehive.jpa.repository.TenderDataRepo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@NoArgsConstructor
public class TenderDataDAOImpl implements TenderDataDAO{
    TenderDataRepo repo;
    @Autowired
    public TenderDataDAOImpl(TenderDataRepo repo) {
        this.repo = repo;
    }

    @Override
    public TenderDataEntity findById(int id) {
        return this.repo.findById(id).get();
    }
}
