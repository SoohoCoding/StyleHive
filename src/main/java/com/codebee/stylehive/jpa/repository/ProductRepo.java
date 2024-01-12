package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
    // 상품 검색 기능
    List<ProductEntity> findByProductEngNameContainingOrProductKorNameContainingOrProductBrand_ProductBrandIdIn(
            String engName, String korName, List<Integer> brandIds);
}
