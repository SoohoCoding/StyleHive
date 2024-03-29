package com.codebee.stylehive.service;

import com.codebee.stylehive.dto.ProductBrandDTO;
import com.codebee.stylehive.dto.ProductDTO;
import com.codebee.stylehive.dto.ProductDealDTO;
import com.codebee.stylehive.jpa.entity.product.ProductEntity;

import java.util.List;

public interface ProductService {
    public ProductDTO findById(int id);
    public List<ProductDealDTO> findAllProductDealByProductId(int productId);
    public List<ProductDTO> findProductByBrandOrderByDealCount(int brandId, int limit, int currentProductId);

    public String findProductByKeyword(String keyword, int size, int page);

    public String findProductSortDate (int size, int page);

    public List<ProductBrandDTO> findTop10Brand();
    public List<ProductDTO> findTop8Product();
}
