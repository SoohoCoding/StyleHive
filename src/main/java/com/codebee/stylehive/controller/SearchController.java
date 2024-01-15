package com.codebee.stylehive.controller;


import com.codebee.stylehive.jpa.entity.ProductBrandEntity;
import com.codebee.stylehive.jpa.entity.ProductEntity;
import com.codebee.stylehive.service.SearchService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@NoArgsConstructor
@RequestMapping("/api/search")
public class SearchController {
    SearchService service;

    @Autowired
    public SearchController(SearchService service) {
        this.service = service;
    }

    // 검색 결과 페이지
    @GetMapping
    public Object search(@RequestParam String keyword, @RequestParam(defaultValue = "products") String tab) {

        if ("users".equals(tab)) {
            return service.searchUsers(keyword);
        } else if ("communities".equals(tab)) {
            return service.searchCommunities(keyword);
        } else {
            return service.searchProducts(keyword);
        }
    }

    // 인기 상품 상위 10개
    @GetMapping("/top10ProductsByTenderCount")
    public List<ProductEntity> getTop10ProductsByTenderCount() {
        return service.getTop10ProductsByTenderCount();
    }

    // 인기 브랜드 상위 10개
    @GetMapping("/top10BrandsByTenderCount")
    public List<ProductBrandEntity> getTop10BrandsByTenderCount() {
        return service.getTop10BrandsByTenderCount();
    }
}
