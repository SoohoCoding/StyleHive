package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.PushAlarmEntity;
import com.codebee.stylehive.jpa.repository.PushAlarmRepo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@NoArgsConstructor
public class PushAlarmDAOImpl implements PushAlarmDAO {

    PushAlarmRepo repo;

    @Autowired
    public PushAlarmDAOImpl(PushAlarmRepo repo) {
        this.repo = repo;
    }

    @Override
    public PushAlarmEntity findById(int id) {
        return this.repo.findById(id).get();
    }
}
