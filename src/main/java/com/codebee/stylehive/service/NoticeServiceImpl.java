package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.NoticeEntity;
import com.codebee.stylehive.repository.NoticeDAO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class NoticeServiceImpl implements NoticeService {
    NoticeDAO dao;

    @Autowired
    public NoticeServiceImpl(NoticeDAO dao) {
        this.dao = dao;
    }

    @Override
    public Page<NoticeEntity> getAllNotices(Pageable pageable) {
        return dao.getAllNotices(pageable);
    }

    @Override
    public NoticeEntity getNoticeDetail(int noticeNo) {
        return dao.getNoticeDetail(noticeNo);
    }
}
