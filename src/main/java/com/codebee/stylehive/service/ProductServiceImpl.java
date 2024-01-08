package com.codebee.stylehive.service;

import com.codebee.stylehive.dto.ProductDealDTO;
import com.codebee.stylehive.jpa.entity.product.ProductEntity;
import com.codebee.stylehive.repository.ProductDAO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<ProductDealDTO> findAllProductDealByProductId(int productId) {
        return dao.findAllProductDealByProductId(productId);
    }
}
