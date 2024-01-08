package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
    // 상품 검색 기능
    Page<ProductEntity> findByProductEngNameContainingOrProductKorNameContainingOrProductBrandContainingOrProductCateId(
            String engName, String korName, String brand, int cateId, Pageable pageable);
}
