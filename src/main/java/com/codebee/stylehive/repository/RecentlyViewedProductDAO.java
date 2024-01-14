package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.ProductEntity;
import com.codebee.stylehive.jpa.entity.RecentlyViewedProductEntity;

import java.util.List;

public interface RecentlyViewedProductDAO {
    List<RecentlyViewedProductEntity> getRecentlyViewedProducts(String userId);

    void addToRecentlyViewedProducts(String userId, ProductEntity product);
}
