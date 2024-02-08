package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.community.CommunityTagProductEntity;
import com.codebee.stylehive.jpa.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityTagProductRepo extends JpaRepository<CommunityTagProductEntity, Integer> {
    int countByProduct(ProductEntity product);

    List<CommunityTagProductEntity> findByProduct_ProductIdIn(List<Integer> productIds);
}