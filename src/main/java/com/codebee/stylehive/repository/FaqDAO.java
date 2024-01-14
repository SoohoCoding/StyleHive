package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.FaqEntity;

import java.util.List;

public interface FaqDAO {
    List<FaqEntity> getAllFaqs();
}
