package com.codebee.stylehive.controller;

import com.codebee.stylehive.jpa.entity.ProductEntity;
import com.codebee.stylehive.jpa.entity.RecentlyViewedProductEntity;
import com.codebee.stylehive.service.RecentlyViewedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@SessionAttributes("/api/recentlyViewedProduct")
public class RecentlyViewedProductController {
    RecentlyViewedProductService service;

    @Autowired
    public RecentlyViewedProductController(RecentlyViewedProductService service) {
        this.service = service;
    }

//    @GetMapping("/list")
//    public ResponseEntity<List<ProductEntity>> getRecentlyViewedProducts() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String userId = authentication.getName();
//
//        List<RecentlyViewedProductEntity> recentlyViewedProducts = service.getRecentlyViewedProducts(userId);
//
//        // RecentlyViewedProductEntity를 ProductEntity로 변환
//        List<ProductEntity> products = recentlyViewedProducts.stream()
//                .map(recentlyViewedProduct -> recentlyViewedProduct.getProduct())
//                .collect(Collectors.toList());
//
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<String> addToRecentlyViewedProducts(@RequestBody ProductEntity product) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String userId = authentication.getName();
//
//        service.addToRecentlyViewedProducts(userId, product);
//        return new ResponseEntity<>("Product added to recently viewed.", HttpStatus.OK);
//    }
}
