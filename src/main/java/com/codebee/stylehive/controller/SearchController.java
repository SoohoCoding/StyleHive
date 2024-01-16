package com.codebee.stylehive.controller;


import com.codebee.stylehive.jpa.entity.ProductBrandEntity;
import com.codebee.stylehive.jpa.entity.ProductEntity;
import com.codebee.stylehive.jpa.entity.SearchStatsEntity;
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
        // 검색 통계 수집
        service.logSearch(keyword);
        if ("users".equals(tab)) {
            return service.searchUsers(keyword);
        } else if ("communities".equals(tab)) {
            return service.searchCommunities(keyword);
        } else {
            return service.searchProducts(keyword);
        }
    }

    // 추천 상품 상위 5개
    @GetMapping("/top5ProductsByTenderCount")
    public List<ProductEntity> getTop5ProductsByTenderCount() {
        return service.getTop5ProductsByTenderCount();
    }

    // 인기 검색어 상위 20개
    @GetMapping("/top20PopularByTenderCount")
    public List<SearchStatsEntity> getTop20PopularSearches() {
        return service.getTop20PopularSearches();
    }

    // 인기 브랜드 상위 6개
    @GetMapping("/top6BrandsByTenderCount")
    public List<ProductBrandEntity> getTop6BrandsByTenderCount() {
        return service.getTop6BrandsByTenderCount();
    }
}
