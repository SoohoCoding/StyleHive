package com.codebee.stylehive.controller;

import com.codebee.stylehive.jpa.entity.ProductEntity;
import com.codebee.stylehive.service.ProductService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
@RequestMapping("/api/search")
public class SearchController {
    ProductService productService;

    @Autowired
    public SearchController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public Page<ProductEntity> searchProducts(@RequestParam String keyword, @RequestParam int page, @RequestParam int size) {
        return productService.searchProducts(keyword, page, size);
    }
}
