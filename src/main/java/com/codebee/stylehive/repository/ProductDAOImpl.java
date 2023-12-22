package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.ProductEntity;
import com.codebee.stylehive.jpa.repository.ProductRepo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
}
