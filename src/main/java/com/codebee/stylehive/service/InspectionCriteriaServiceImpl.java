package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.InspectionCriteriaEntity;
import com.codebee.stylehive.repository.InspectionCriteriaDAO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class InspectionCriteriaServiceImpl implements InspectionCriteriaService {
    InspectionCriteriaDAO dao;

    @Autowired
    public InspectionCriteriaServiceImpl(InspectionCriteriaDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<String> getInspectionTitles() {
        return dao.getInspectionTitles();
    }

    @Override
    public InspectionCriteriaEntity getInspectionCriteriaByTitle(String title) {
        return dao.findByTitle(title);
    }
}
