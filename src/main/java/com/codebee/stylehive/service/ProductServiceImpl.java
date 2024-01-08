package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.ProductEntity;
import com.codebee.stylehive.repository.ProductDAO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ProductServiceImpl implements ProductService {

    ProductDAO dao;

    @Autowired
    public ProductServiceImpl(ProductDAO dao) {
        this.dao = dao;
    }

    @Override
    public ProductEntity findById(int id) {
        return dao.findById(id);
    }

    // 상품 검색 기능
    @Override
    public Page<ProductEntity> searchProducts(String keyword, int page, int size) {
        return dao.searchProducts(keyword, page*size, size);
    }
}
