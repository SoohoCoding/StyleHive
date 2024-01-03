package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.FaqEntity;
import com.codebee.stylehive.jpa.repository.FaqRepo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@NoArgsConstructor
public class FaqDAOImpl implements FaqDAO {
    FaqRepo repo;

    @Autowired
    public FaqDAOImpl(FaqRepo repo) {
        this.repo = repo;
    };

    @Override
    public Page<FaqEntity> getAllFaqs(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Page<FaqEntity> getFaqsByCategory(String category, Pageable pageable) {
        return repo.findByFaqCate(category, pageable);
    }


}
