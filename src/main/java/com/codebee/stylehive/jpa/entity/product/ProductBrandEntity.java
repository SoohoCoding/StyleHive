package com.codebee.stylehive.jpa.entity.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_brand")
public class ProductBrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int productBrandId;
    String productBrandEngName;
    String productBrandKorName;
    String productBrandImg;
}
