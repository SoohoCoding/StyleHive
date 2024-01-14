package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.ProductEntity;
import com.codebee.stylehive.jpa.entity.RecentlyViewedProductEntity;
import com.codebee.stylehive.jpa.entity.UserInfoEntity;
import com.codebee.stylehive.jpa.repository.RecentlyViewedProductRepo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@NoArgsConstructor
public class RecentlyViewedProductDAOImpl implements RecentlyViewedProductDAO {
    RecentlyViewedProductRepo repo;

    @Autowired
    public RecentlyViewedProductDAOImpl(RecentlyViewedProductRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<RecentlyViewedProductEntity> getRecentlyViewedProducts(String userId) {
        return repo.findByUserInfoUserId(userId);
    }

    @Override
    public void addToRecentlyViewedProducts(String userId, ProductEntity product) {
        RecentlyViewedProductEntity recentlyViewedProduct = new RecentlyViewedProductEntity();
        recentlyViewedProduct.setUserInfo(new UserInfoEntity(userId)); // 사용자 ID를 설정하는 부분
        recentlyViewedProduct.setProduct(product);
        recentlyViewedProduct.setViewedAt(new Date());

        repo.save(recentlyViewedProduct);
    }
}
