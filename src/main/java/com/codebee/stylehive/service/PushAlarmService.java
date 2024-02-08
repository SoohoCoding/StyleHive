package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.PushAlarmEntity;

import java.util.List;

public interface PushAlarmService {
    public PushAlarmEntity findById(int id);
    public List<PushAlarmEntity> findAll();
}
