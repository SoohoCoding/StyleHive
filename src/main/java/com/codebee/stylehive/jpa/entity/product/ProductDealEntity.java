package com.codebee.stylehive.jpa.entity.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_deal")
public class ProductDealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int dealId;
    int productId;
    String dealSellId;
    String dealBuyId;
    int productSizeId;
    String dealProgress;
    String dealPayment;
    int dealPrice;
    Timestamp dealDate;
    int dealInspectionId;
    int couId;
}
