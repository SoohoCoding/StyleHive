package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.ProductEntity;
import org.springframework.data.domain.Page;

public interface ProductDAO {
    public ProductEntity findById(int id);

    // 상품 검색 기능
    Page<ProductEntity> searchProducts(String keyword, int offset, int limit);
}
