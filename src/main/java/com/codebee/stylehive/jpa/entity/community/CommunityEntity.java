package com.codebee.stylehive.jpa.entity.community;

import com.codebee.stylehive.jpa.entity.ImgThumbEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
    String commTitle;
    String commContents;
    int commCategory;
    int commViewer;
    Timestamp commDate;
    Timestamp commUpdate;
    boolean commState;

    @OneToMany
    @JoinColumn(name = "commNo")
    List<ImgThumbEntity> imgList = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "commNo")
    List<CommunityTagProductEntity> tagProductList = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "commNo")
    List<CommunityTagProductEntity> tagList = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "commNo")
    List<CommunityCommentEntity> CommentList = new ArrayList<>();
}
