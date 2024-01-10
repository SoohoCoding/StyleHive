package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.FaqEntity;
import com.codebee.stylehive.jpa.repository.FaqRepo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@NoArgsConstructor
public class FaqDAOImpl implements FaqDAO {
    FaqRepo repo;

    @Autowired
    public FaqDAOImpl(FaqRepo repo) {
        this.repo = repo;
    };

    @Override
    public List<FaqEntity> getAllFaqs() {
        return repo.findAll();
    }
}
