package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.PushAlarmEntity;

import java.util.List;

public interface PushAlarmDAO {
    public PushAlarmEntity findById(int id);
    public List<PushAlarmEntity> findAll();
}
