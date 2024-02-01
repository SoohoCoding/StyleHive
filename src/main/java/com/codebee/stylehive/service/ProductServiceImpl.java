package com.codebee.stylehive.service;

import com.codebee.stylehive.dto.ProductBrandDTO;
import com.codebee.stylehive.dto.ProductDTO;
import com.codebee.stylehive.dto.ProductDealDTO;
import com.codebee.stylehive.jpa.entity.product.ProductEntity;
import com.codebee.stylehive.repository.ProductDAO;
import com.google.gson.Gson;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
public class ProductServiceImpl implements ProductService {

    ProductDAO dao;

    @Autowired
    public ProductServiceImpl(ProductDAO dao) {
        this.dao = dao;
    }

    @Override
    public ProductDTO findById(int id) {
        return ProductDTO.of(dao.findById(id));
    }

    @Override
    public List<ProductDealDTO> findAllProductDealByProductId(int productId) {
        return dao.findAllProductDealByProductId(productId);
    }

    @Override
    public List<ProductDTO> findProductByBrandOrderByDealCount(int brandId, int limit, int currentProductId) {
        return dao.findProductByBrandOrderByDealCount(brandId, limit, currentProductId);
    }

    @Override
    public String findProductByKeyword(String keyword, int size, int page) {
        List<ProductDTO> result = dao.findProductBySearchKeyword(keyword, size, page);
        int count = dao.findProductBySearchKeywordCount(keyword);
        boolean hasNextPage = count - (size * page) > 0;
        Map<String, Object> map = new HashMap<>();
        map.put("productList", result);
        map.put("hasNextPage", hasNextPage);

        return new Gson().toJson(map);
    }

    @Override
    public String findProductSortDate(int size, int page) {
        List<ProductDTO> result = dao.findProductSortDate(size, page);
        int count = dao.countAllProduct();
        boolean hasNextPage = count - (size * page) > 0;
        Map<String, Object> map = new HashMap<>();
        map.put("productList", result);
        map.put("hasNextPage", hasNextPage);

        return new Gson().toJson(map);
    }

    @Override
    public List<ProductBrandDTO> findTop10Brand() {
        return dao.findTop10Brand();
    }

    @Override
    public List<ProductDTO> findTop8Product() {
        return dao.selectTop8Product();
    }
}
