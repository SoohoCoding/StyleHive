package com.codebee.stylehive.service;

import com.codebee.stylehive.dto.ProductDTO;
import com.codebee.stylehive.dto.ProductDealDTO;
import com.codebee.stylehive.jpa.entity.product.ProductEntity;

import java.util.List;

public interface ProductService {
    public ProductDTO findById(int id);
    public List<ProductDealDTO> findAllProductDealByProductId(int productId);
    public List<ProductDTO> findProductByBrandOrderByDealCount(int brandId, int limit, int currentProductId);
}
