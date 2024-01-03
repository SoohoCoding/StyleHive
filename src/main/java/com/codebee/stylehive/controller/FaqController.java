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

    @GetMapping("/all")
    public Page<FaqEntity> getAllFaqs(@RequestParam(defaultValue = "1") int page) {
        int size = 20;
        Pageable pageable = PageRequest.of(page-1, size);
        return service.getAllFaqs(pageable);
    }

    @GetMapping
    public Page<FaqEntity> getFaqsByCategory(@RequestParam(required = false) String category,
                                             @RequestParam(defaultValue = "1") int page) {
        int size = 20;
        Pageable pageable = PageRequest.of(page - 1, size);

        if (category == null || category.equals("전체")) {
            return service.getAllFaqs(pageable);
        } else {
            return service.getFaqsByCategory(category, pageable);
        }
    }
}
