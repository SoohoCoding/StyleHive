package com.codebee.stylehive.controller;

import com.codebee.stylehive.jpa.entity.RecentlyViewedProductEntity;
import com.codebee.stylehive.service.RecentlyViewedProductService;
import jakarta.servlet.http.HttpSession;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@NoArgsConstructor
public class RecentlyViewedProductController {
    RecentlyViewedProductService service;

    @Autowired
    public RecentlyViewedProductController(RecentlyViewedProductService service) {
        this.service = service;
    }

    @PostMapping("/api/recentlyViewedProduct/save")
    public void saveRecentlyViewedProduct(@RequestBody RecentlyViewedProductEntity product) {
        service.save(product);
    }

    @GetMapping("/api/recentlyViewedProduct")
    @ResponseBody
    public List<RecentlyViewedProductEntity> getRecentlyViewedProductsByUserId(HttpSession session) {
        String userId = (String) session.getAttribute("userId"); // 세션에서 로그인한 사용자의 아이디를 가져옵니다.

        if (userId != null && !userId.isEmpty()) {
            // 로그인한 사용자의 아이디로 최근 본 상품 목록을 조회합니다.
            return service.findByUserId(userId);
        } else {
            // 세션에 로그인한 사용자의 아이디가 없는 경우, 빈 리스트를 반환합니다.
            return Collections.emptyList();
        }
    }
}
