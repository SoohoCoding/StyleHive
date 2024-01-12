package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.CommTagEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// CommTagEntityRepository
public interface CommTagRepo extends JpaRepository<CommTagEntity, Integer> {
    List<CommTagEntity> findByTag_TagId(int tagId);
}
