package com.codebee.stylehive.jpa.entity.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_size")
public class ProductSizeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int productSizeId;
    int productId;
    String productSizeValue;
}
