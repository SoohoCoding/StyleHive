package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.RecentlyViewedProductEntity;

import java.util.List;

public interface RecentlyViewedProductDAO {
    void save(RecentlyViewedProductEntity product);
    List<RecentlyViewedProductEntity> findByUserId(String userId);
}
