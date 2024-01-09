package com.codebee.stylehive.jpa.entity.community;

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
    int commId;
    int commNo;
    String userId;
}
