package com.codebee.stylehive.controller;


import com.codebee.stylehive.service.SearchService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@NoArgsConstructor
@RequestMapping("/api/search")
public class SearchController {
    SearchService service;

    @Autowired
    public SearchController(SearchService service) {
        this.service = service;
    }

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
}
