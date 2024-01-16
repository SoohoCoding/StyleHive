package com.codebee.stylehive.repository;

import com.codebee.stylehive.dto.ProductDTO;
import com.codebee.stylehive.dto.ProductDealDTO;
import com.codebee.stylehive.jpa.entity.product.ProductEntity;

import java.util.List;

public interface ProductDAO {
    public ProductEntity findById(int id);
    public List<ProductDealDTO> findAllProductDealByProductId(int productId);
    public List<ProductDTO> findProductByBrandOrderByDealCount(int brandId, int limit, int currentProductId);

    public List<ProductDTO> findProductBySearchKeyword(String keyword, int size, int page);
    public int findProductBySearchKeywordCount(String keyword);
}
