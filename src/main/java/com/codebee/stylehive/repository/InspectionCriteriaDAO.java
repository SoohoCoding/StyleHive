package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.InspectionCriteriaEntity;

import java.util.List;

public interface InspectionCriteriaDAO {
    List<String> getInspectionTitles();
    InspectionCriteriaEntity findByTitle(String title);
}
