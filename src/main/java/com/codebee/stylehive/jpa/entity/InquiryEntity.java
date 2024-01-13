package com.codebee.stylehive.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inquiry")
public class InquiryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int inqNo;
    int dealId;
    String userId;
    String inqTitle;
    String inqContents;
    Date inqDate;
    Date inqUpdate;
    String id;
}
