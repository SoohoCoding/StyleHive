package com.codebee.stylehive.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "search_stats")
public class SearchStatsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int searchStatsNo;

    @Column(nullable = false)
    private String keyword;

    @Column(nullable = false)
    private int searchCount;
}
