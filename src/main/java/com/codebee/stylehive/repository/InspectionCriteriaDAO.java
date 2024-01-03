package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.InspectionCriteriaEntity;

public interface InspectionCriteriaDAO {
    InspectionCriteriaEntity findByTitle(String title);
}
