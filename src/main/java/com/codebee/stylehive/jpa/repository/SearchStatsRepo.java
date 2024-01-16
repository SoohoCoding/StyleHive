package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.SearchStatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


import java.util.List;

public interface SearchStatsRepo extends JpaRepository<SearchStatsEntity, Long> {
    @Modifying
    @Query("UPDATE SearchStatsEntity s SET s.searchCount = s.searchCount + 1 WHERE s.keyword = :keyword")
    void incrementSearchCount(@Param("keyword") String keyword);

    @Query("SELECT s FROM SearchStatsEntity s ORDER BY s.searchCount DESC limit 20")
    List<SearchStatsEntity> findPopularSearches();

}
