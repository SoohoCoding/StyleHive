package com.codebee.stylehive.dto;

import com.codebee.stylehive.jpa.entity.ImgThumbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("community")
public class CommunityDTO {
    int commNo;
    String userId;
    String commTitle;
    String commContents;
    int commCategory;
    int commViewer;
    Timestamp commDate;
    Timestamp commUpdate;
    boolean commState;

    int likeCount;
    int commentCount;

    List<ImgThumbEntity> imgList = new ArrayList<>();
    List<ProductDTO> tagProductList = new ArrayList<>();
    List<TagDTO> tagList = new ArrayList<>();
    String firstImage;
    String userImg;
}
