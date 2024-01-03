package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.FaqEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FaqDAO {
    Page<FaqEntity> getAllFaqs(Pageable pageable);
    Page<FaqEntity> getFaqsByCategory(String category, Pageable pageable);
}
