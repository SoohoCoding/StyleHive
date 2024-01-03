package com.codebee.stylehive.controller;

import com.codebee.stylehive.jpa.entity.NoticeEntity;
import com.codebee.stylehive.service.NoticeService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;



@RestController
@NoArgsConstructor
@RequestMapping("/api/notice")
public class NoticeController {
    NoticeService service;

    @Autowired
    public NoticeController(NoticeService service) {
        this.service = service;
    }

    @GetMapping
    public Page<NoticeEntity> getAllNotices(@RequestParam(defaultValue = "1") int page) {
        int size = 20;
        Pageable pageable = PageRequest.of(page - 1, size);
        return service.getAllNotices(pageable);
    }

    @GetMapping("/{noticeNo}")
    public NoticeEntity getNoticeDetail(@PathVariable int noticeNo) {
        System.out.println(service.getNoticeDetail(noticeNo));
        return service.getNoticeDetail(noticeNo);
    }
}
