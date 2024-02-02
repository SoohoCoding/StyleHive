package com.codebee.stylehive.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "community_like")
public class CommunityLikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int commLikeId;
    int commNo;
    int userId;
}
