package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.ProductEntity;

public interface ProductDAO {
    public ProductEntity findById(int id);
}
