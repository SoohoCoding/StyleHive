package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.UserLikeEntity;
import com.codebee.stylehive.jpa.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLikeRepo extends JpaRepository<UserLikeEntity, Integer> {
    // 해당 제품에 대한 북마크의 개수를 반환하는 메서드
    int countByProduct(ProductEntity product);
}
