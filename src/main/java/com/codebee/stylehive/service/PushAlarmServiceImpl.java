package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.PushAlarmEntity;
import com.codebee.stylehive.repository.PushAlarmDAO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class PushAlarmServiceImpl implements PushAlarmService{
    PushAlarmDAO dao;
    @Autowired
    public PushAlarmServiceImpl(PushAlarmDAO dao) {
        this.dao = dao;
    }

    @Override
    public PushAlarmEntity findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<PushAlarmEntity> findAll() {
        return dao.findAll();
    }
}
