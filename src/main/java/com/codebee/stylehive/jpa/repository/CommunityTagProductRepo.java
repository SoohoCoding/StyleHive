package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.CommunityTagProductEntity;
import com.codebee.stylehive.jpa.entity.ProductEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommunityTagProductRepo extends JpaRepository<CommunityTagProductEntity, Integer> {
    int countByProduct(ProductEntity product);

    List<CommunityTagProductEntity> findByProduct_ProductIdIn(List<Integer> productIds);
}