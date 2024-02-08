package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.RecentlyViewedProductEntity;

import java.util.List;

public interface RecentlyViewedProductService {
    void save(RecentlyViewedProductEntity product);
    List<RecentlyViewedProductEntity> findByUserId(String userId);
}
