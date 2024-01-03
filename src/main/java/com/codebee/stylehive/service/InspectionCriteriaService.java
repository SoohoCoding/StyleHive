package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.InspectionCriteriaEntity;

public interface InspectionCriteriaService {
    InspectionCriteriaEntity getInspectionCriteriaByTitle(String title);
}
