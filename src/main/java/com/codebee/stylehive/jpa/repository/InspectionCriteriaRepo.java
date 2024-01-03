package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.InspectionCriteriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionCriteriaRepo extends JpaRepository<InspectionCriteriaEntity, Integer> {
    InspectionCriteriaEntity findByInspectionTitle(String title);
}
