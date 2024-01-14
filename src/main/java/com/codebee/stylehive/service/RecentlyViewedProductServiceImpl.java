package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.ProductEntity;
import com.codebee.stylehive.jpa.entity.RecentlyViewedProductEntity;
import com.codebee.stylehive.repository.RecentlyViewedProductDAO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class RecentlyViewedProductServiceImpl implements RecentlyViewedProductService {
    RecentlyViewedProductDAO dao;

    @Autowired
    public RecentlyViewedProductServiceImpl(RecentlyViewedProductDAO dao) {
        this.dao=dao;
    }

    @Override
    public List<RecentlyViewedProductEntity> getRecentlyViewedProducts(String userId) {
        return dao.getRecentlyViewedProducts(userId);
    }

    @Override
    public void addToRecentlyViewedProducts(String userId, ProductEntity product) {
        dao.addToRecentlyViewedProducts(userId, product);
    }
}
