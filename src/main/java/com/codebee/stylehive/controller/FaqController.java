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

import java.util.List;

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
    public List<FaqEntity> getAllFaqs() {
        return service.getAllFaqs();
    }

}
