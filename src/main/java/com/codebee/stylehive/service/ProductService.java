package com.codebee.stylehive.service;

import com.codebee.stylehive.dto.ProductDealDTO;
import com.codebee.stylehive.jpa.entity.product.ProductEntity;

import java.util.List;

public interface ProductService {
    public ProductEntity findById(int id);
    public List<ProductDealDTO> findAllProductDealByProductId(int productId);
}
