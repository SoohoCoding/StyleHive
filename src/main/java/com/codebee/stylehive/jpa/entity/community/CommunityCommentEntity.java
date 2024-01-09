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
@Table(name = "community_comment")
public class CommunityCommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int commMentNo;
    int commNo;
    String userId;
    String commMentContents;
    Timestamp commMentDate;
    Timestamp commMentUpdate;
    int commMentGroupNo;
    int commMentOrderNo;
    boolean commMentState;
}
