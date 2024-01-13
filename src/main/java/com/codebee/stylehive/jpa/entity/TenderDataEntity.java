package com.codebee.stylehive.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tenderData")
public class TenderDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int dataNo;
    int productId;
    int dealId;
    int tenderNum;
    String userId;
    int tenderPrice;
    int tenderRecentPrice;
}
