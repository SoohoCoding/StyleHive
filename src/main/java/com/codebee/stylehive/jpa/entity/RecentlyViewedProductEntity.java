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
@Table(name = "recently_viewed_product")
public class RecentlyViewedProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recentlyNo;
    private int productId;
    private String userId;
    private Date viewedAt;
}
