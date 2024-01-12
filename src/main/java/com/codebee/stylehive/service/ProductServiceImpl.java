package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.ProductEntity;
import com.codebee.stylehive.repository.ProductDAO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
