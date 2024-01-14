package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.NoticeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepo extends JpaRepository<NoticeEntity, Integer> {
    Page<NoticeEntity> findAllByOrderByNoticeNoDesc(Pageable pageable);
}
