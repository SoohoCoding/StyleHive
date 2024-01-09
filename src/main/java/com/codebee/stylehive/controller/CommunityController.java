package com.codebee.stylehive.controller;

import com.codebee.stylehive.dto.CommunityDTO;
import com.codebee.stylehive.jpa.entity.community.CommunityEntity;
import com.codebee.stylehive.service.CommunityService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping("/api/community")
public class CommunityController {

    CommunityService service;

    @Autowired
    public CommunityController(CommunityService service) {
        this.service = service;
    }

    @GetMapping("/{styleId}")
    public CommunityDTO getById(@PathVariable("styleId") int styleId) {
        return service.findById(styleId);
    }

    @GetMapping("/pid/{productId}/{limit}")
    public String getByProductId(@PathVariable("productId") int productId, @PathVariable("limit")int limit) {
        return service.findByProductIdWithCount(productId, limit);
    }

    @GetMapping("/pcate/{cateId}/{size}/{page}")
    public String getByProductCate(@PathVariable("cateId") int cateId, @PathVariable("size")int size, @PathVariable("page")int page) {
        return service.findByProductCate(cateId, size, page);
    }
}
