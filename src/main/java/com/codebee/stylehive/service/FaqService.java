package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.FaqEntity;

import java.util.List;

public interface FaqService {
    List<FaqEntity> getAllFaqs();
}
