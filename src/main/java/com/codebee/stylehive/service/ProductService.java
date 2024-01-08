package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.ProductEntity;
import org.springframework.data.domain.Page;

public interface ProductService {
    public ProductEntity findById(int id);

    // 상품 검색 기능
    Page<ProductEntity> searchProducts(String keyword, int page, int size);
}
