package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.InspectionCriteriaEntity;
import com.codebee.stylehive.repository.InspectionCriteriaDAO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class InspectionCriteriaServiceImpl implements InspectionCriteriaService {
    InspectionCriteriaDAO dao;

    @Autowired
    public InspectionCriteriaServiceImpl(InspectionCriteriaDAO dao) {
        this.dao = dao;
    }

    @Override
    public InspectionCriteriaEntity getInspectionCriteriaByTitle(String title) {
        return dao.findByTitle(title);
    }
}
