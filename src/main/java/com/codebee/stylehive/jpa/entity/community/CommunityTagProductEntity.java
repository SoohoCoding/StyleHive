package com.codebee.stylehive.jpa.entity.community;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "community_tag_product")
public class CommunityTagProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int commProductId;
    int commNo;
    int productId;
}
