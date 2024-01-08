package com.codebee.stylehive.controller;

import com.codebee.stylehive.jpa.entity.InspectionCriteriaEntity;
import com.codebee.stylehive.service.InspectionCriteriaService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inspection")
public class InspectionCriteriaController {
    private final InspectionCriteriaService service;

    @Autowired
    public InspectionCriteriaController(InspectionCriteriaService service) {
        this.service = service;
    }

    @GetMapping("/titles")
    public List<String> getInspectionTitles() {
        // 서비스를 통해 검수 기준 title 목록을 가져온다.
        return service.getInspectionTitles();
    }

    @GetMapping("/{title}")
    public InspectionCriteriaEntity getInspectionCriteriaByTitle(@PathVariable String title) {
        System.out.println(title);
        return service.getInspectionCriteriaByTitle(title);
    }
}
