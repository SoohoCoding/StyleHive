package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.TenderDataEntity;
import com.codebee.stylehive.repository.TenderDataDAO;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class TenderDataServiceImpl implements TenderDataService {

    TenderDataDAO dao;

    public TenderDataServiceImpl(TenderDataDAO dao) {
        this.dao = dao;
    }

    @Override
    public TenderDataEntity findById(int id) {
        return dao.findById(id);
    }
}