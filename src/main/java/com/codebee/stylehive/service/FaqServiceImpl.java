package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.FaqEntity;
import com.codebee.stylehive.repository.FaqDAO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class FaqServiceImpl implements FaqService {
    FaqDAO dao;

    @Autowired
    public FaqServiceImpl(FaqDAO dao) {
        this.dao = dao;
    }

    @Override
    public Page<FaqEntity> getAllFaqs(Pageable pageable) {
        return dao.getAllFaqs(pageable);
    }

    @Override
    public Page<FaqEntity> getFaqsByCategory(String category, Pageable pageable) {
        return dao.getFaqsByCategory(category, pageable);
    }
}
