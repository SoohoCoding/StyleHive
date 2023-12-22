package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepo extends JpaRepository<TestEntity, String> {

}
