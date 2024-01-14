package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.FaqEntity;
import com.codebee.stylehive.repository.FaqDAO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class FaqServiceImpl implements FaqService {
    FaqDAO dao;

    @Autowired
    public FaqServiceImpl(FaqDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<FaqEntity> getAllFaqs() {
        return dao.getAllFaqs();
    }
}
