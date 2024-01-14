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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private UserInfoEntity userInfo;
    private Date viewedAt;
}
