package com.codebee.stylehive.jpa.entity.community;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "community")
public class CommunityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int commNo;
    String userId;
    int productId;
    int tagNo;
    String commTitle;
    String commContents;
    int commCategory;
    int commViewer;
    Timestamp commDate;
    Timestamp commUpdate;
    boolean commState;
}
