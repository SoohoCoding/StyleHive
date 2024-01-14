package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.product.ProductBrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductBrandRepo extends JpaRepository<ProductBrandEntity, Integer> {// 브랜드명으로 검색
    List<ProductBrandEntity> findByProductBrandEngNameContainingOrProductBrandKorNameContaining(String engName, String korName);
}
