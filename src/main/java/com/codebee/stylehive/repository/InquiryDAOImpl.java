package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.InquiryEntity;
import com.codebee.stylehive.jpa.repository.InquiryRepo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@NoArgsConstructor
public class InquiryDAOImpl implements InquiryDAO {
    InquiryRepo repo;

    @Autowired
    public InquiryDAOImpl(InquiryRepo repo){
        this.repo=repo;
    }

    @Override
    public InquiryEntity findById(int id) {
        return this.repo.findById(id).get();
    }
}
