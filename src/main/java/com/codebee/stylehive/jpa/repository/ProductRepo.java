package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
    // 상품 검색 기능
    List<ProductEntity> findByProductEngNameContainingOrProductKorNameContainingOrProductBrand_ProductBrandIdIn(
            String engName, String korName, List<Integer> brandIds);
    // 상품 검색 기능
    List<ProductEntity> findByProductEngNameContainingOrProductKorNameContainingOrProductBrand_ProductBrandIdIn(
            String engName, String korName, List<Integer> brandIds);

    // 추천 상품 상위 5개
    List<ProductEntity> findByProductIdIn(List<Integer> productIds);

    // 연관 검섹어 상위 5개
    List<ProductEntity> findByProductEngNameContainingOrProductKorNameContaining(String productEngName, String productKorName);

    // 자동 완성 검색어 상위 10개
    List<ProductEntity> findByProductBrand_ProductBrandIdIn(List<Integer> brandIds);
}
