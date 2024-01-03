package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.FaqEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FaqService {
    Page<FaqEntity> getAllFaqs(Pageable pageable);
    Page<FaqEntity> getFaqsByCategory(String category, Pageable pageable);
    Page<FaqEntity> searchAllFaqs(String search, Pageable pageable);
}
