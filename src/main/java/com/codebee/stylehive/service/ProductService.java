package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.ProductEntity;

public interface ProductService {
    public ProductEntity findById(int id);
}
