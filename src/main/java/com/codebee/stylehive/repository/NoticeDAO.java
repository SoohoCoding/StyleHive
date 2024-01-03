package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.NoticeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoticeDAO {
    Page<NoticeEntity> getAllNotices(Pageable pageable);

    NoticeEntity getNoticeDetail(int noticeNo);
}
