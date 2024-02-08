package com.codebee.stylehive.jpa.entity.community;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "community")
public class CommunityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int commNo;
    String userId;
    String commTitle;
    String commContents;
    int commCategory;
    int commViewer;
    Date commDate;
    Date commUpdate;
    Boolean commState;
}
