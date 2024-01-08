package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.InspectionCriteriaEntity;
import com.codebee.stylehive.jpa.repository.InspectionCriteriaRepo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@NoArgsConstructor
public class InspectionCriteriaDAOImpl implements InspectionCriteriaDAO {
    InspectionCriteriaRepo repo;

    @Autowired
    public InspectionCriteriaDAOImpl(InspectionCriteriaRepo repo) {
        this.repo = repo;
    };

    @Override
    public List<String> getInspectionTitles() {
        return repo.findAll().stream()
                .map(InspectionCriteriaEntity::getInspectionTitle)
                .collect(Collectors.toList());
    }

    @Override
    public InspectionCriteriaEntity findByTitle(String title) {
        return repo.findByInspectionTitle(title);
    }
}
