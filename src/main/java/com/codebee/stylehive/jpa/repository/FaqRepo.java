package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.FaqEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqRepo extends JpaRepository<FaqEntity, Integer> {
    Page<FaqEntity> findByFaqCate(String faqCate, Pageable pageable);
    // 검색 기능을 위한 메서드 추가
    Page<FaqEntity> findByFaqTitleContainingOrFaqContentContaining(String title, String content, Pageable pageable);
}
