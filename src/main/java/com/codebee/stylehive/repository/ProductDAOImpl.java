package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.ProductEntity;
import com.codebee.stylehive.jpa.repository.ProductRepo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
@NoArgsConstructor
public class ProductDAOImpl implements ProductDAO {
    ProductRepo repo;

    @Autowired
    public ProductDAOImpl(ProductRepo repo) {
        this.repo = repo;
    }


    @Override
    public ProductEntity findById(int id) {
        return this.repo.findById(id).get();
    }

    // 상품 검색 기능
    @Override
    public Page<ProductEntity> searchProducts(String keyword, int offset, int limit) {
        return repo.findByProductEngNameContainingOrProductKorNameContainingOrProductBrandContainingOrProductCateId(
                keyword, keyword, keyword, Integer.parseInt(keyword), PageRequest.of(offset / limit, limit)
        );
    }
}
