package com.codebee.stylehive.controller;

import com.codebee.stylehive.dto.ProductDealDTO;
import com.codebee.stylehive.jpa.entity.product.ProductEntity;
import com.codebee.stylehive.service.ProductService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping("/api/product")public class ProductContoller {


    ProductService service;

    @Autowired
    public ProductContoller(ProductService service) {
        this.service = service;
    }

    @GetMapping("/{productId}")
    public ProductEntity getById(@PathVariable("productId") int productId) {
        return service.findById(productId);
    }
    @GetMapping("/deal/{productId}")
    public List<ProductDealDTO> getDealById(@PathVariable("productId") int productId) {
        return service.findAllProductDealByProductId(productId);
    }
}
