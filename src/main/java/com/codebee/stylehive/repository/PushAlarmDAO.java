package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.PushAlarmEntity;

public interface PushAlarmDAO {
    public PushAlarmEntity findById(int id);
}
