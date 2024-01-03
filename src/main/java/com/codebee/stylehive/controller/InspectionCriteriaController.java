package com.codebee.stylehive.controller;

import com.codebee.stylehive.jpa.entity.InspectionCriteriaEntity;
import com.codebee.stylehive.service.InspectionCriteriaService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
@RequestMapping("/api/inspection")
public class InspectionCriteriaController {
    InspectionCriteriaService service;

    @Autowired
    public InspectionCriteriaController(InspectionCriteriaService service) {
        this.service = service;
    }

    @GetMapping("/{title}")
    public InspectionCriteriaEntity getInspectionCriteriaByTitle(@PathVariable String title) {
        return service.getInspectionCriteriaByTitle(title);
    }
}
