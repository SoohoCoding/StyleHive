package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.RecentlyViewedProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecentlyViewedProductRepo extends JpaRepository<RecentlyViewedProductEntity, Integer> {
    // 사용자별 최근 본 상품을 조회하기 위한 메서드 등록
    List<RecentlyViewedProductEntity> findByUserInfoUserId(String userId);
}
