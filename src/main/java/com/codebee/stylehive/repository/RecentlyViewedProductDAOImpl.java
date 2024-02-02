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
    public void save(RecentlyViewedProductEntity product) {
        repo.save(product);
    }

    @Override
    public List<RecentlyViewedProductEntity> findByUserId(String userId) {
        return repo.findByUserId(userId);
    }
}
