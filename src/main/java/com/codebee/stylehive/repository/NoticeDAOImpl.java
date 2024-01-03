package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.NoticeEntity;
import com.codebee.stylehive.jpa.repository.NoticeRepo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Repository
@NoArgsConstructor
public class NoticeDAOImpl implements NoticeDAO {
    NoticeRepo repo;

    @Autowired
    public NoticeDAOImpl(NoticeRepo repo) {
        this.repo = repo;
    }

    @Override
    public Page<NoticeEntity> getAllNotices(Pageable pageable) {
        return repo.findAllByOrderByNoticeNoDesc(pageable);
    }

    @Override
    public NoticeEntity getNoticeDetail(int noticeNo) {
        Optional<NoticeEntity> detailEntityOptional = repo.findById(noticeNo);
        return detailEntityOptional.orElse(null);
    }
}
