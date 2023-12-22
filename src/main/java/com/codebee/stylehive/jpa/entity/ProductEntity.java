package com.codebee.stylehive.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int productId;
    int productCateId;
    String productEngName;
    String productKorName;
    String productRelease;
    String productBrand;
    String productColor;
    String productSize;
    String productModelNum;
    Date productDate;
    boolean productState;
}
