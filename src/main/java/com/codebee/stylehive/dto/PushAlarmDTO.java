package com.codebee.stylehive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PushAlarmDTO {
    private int PushAlarmId;
    private String userId;
    private String pushAlarmContent;
    private String pushAlarmDate;
}
