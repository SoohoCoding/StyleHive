package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.TenderDataEntity;

public interface TenderDataDAO {
    public TenderDataEntity findById(int id);

}
