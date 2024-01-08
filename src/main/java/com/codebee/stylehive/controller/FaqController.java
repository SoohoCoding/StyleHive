package com.codebee.stylehive.controller;

import com.codebee.stylehive.jpa.entity.FaqEntity;
import com.codebee.stylehive.service.FaqService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
@RequestMapping("/api/faq")
public class FaqController {
    FaqService service;

    @Autowired
    public FaqController(FaqService service) {
        this.service = service;
    }

    @GetMapping
    public Page<FaqEntity> getFaqsByCategory(@RequestParam(defaultValue = "전체") String category,
                                             @RequestParam(required = false) String search,
                                             @RequestParam(defaultValue = "1") int page) {
        int size = 20;
        Pageable pageable = PageRequest.of(page - 1, size);

        if (search != null && !search.isEmpty()) {
            // 검색어가 입력된 경우
            return service.searchAllFaqs(search, pageable);
        } else {
            // 검색어가 입력되지 않은 경우
            if (category == null || category.equals("전체")) {
                return service.getAllFaqs(pageable);
            } else {
                return service.getFaqsByCategory(category, pageable);
            }
        }
    }
}
