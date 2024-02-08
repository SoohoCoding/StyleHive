package com.codebee.stylehive.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PushAlarm")
public class PushAlarmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PushAlarmId;
    private String userId;
    private String pushAlarmContent;
    private Timestamp pushAlarmDate;
}
