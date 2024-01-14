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
@Table(name = "product_tender")
public class ProductTenderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int tenderNum;
    String userId;
    int productId;
    Timestamp tenderDate;
    boolean tenderFlag;
    int tenderPrice;
    int productSizeId;
}