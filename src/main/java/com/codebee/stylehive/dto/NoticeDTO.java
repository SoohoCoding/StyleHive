package com.codebee.stylehive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDTO {
    private int noticeNo;
    private String userId;
    private String noticeTitle;
    private String noticeContents;
    private String noticeDate;
    private String noticeUpdate;
    private String noticeCate;
}
