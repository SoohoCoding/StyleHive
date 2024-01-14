package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.InspectionCriteriaEntity;

import java.util.List;

public interface InspectionCriteriaService {
    List<String> getInspectionTitles();
    InspectionCriteriaEntity getInspectionCriteriaByTitle(String title);
}
