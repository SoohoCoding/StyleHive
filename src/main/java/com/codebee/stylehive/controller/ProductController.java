package com.codebee.stylehive.controller;

import com.codebee.stylehive.jpa.entity.ProductEntity;
import com.codebee.stylehive.service.ProductService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/{productId}")
    public ProductEntity getById(@PathVariable("productId") int productId) {
        System.out.println(
                service.findById(productId).getProductSize()
        );
        return service.findById(productId);
    }
}
