package com.codebee.stylehive.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "community_tag_product")
public class CommunityTagProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int commProductId;

    @ManyToOne
    @JoinColumn(name = "comm_no", nullable = false)
    private CommunityEntity community;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;


}
