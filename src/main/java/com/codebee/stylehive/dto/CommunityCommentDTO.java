package com.codebee.stylehive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("commComment")
public class CommunityCommentDTO {
    int commMentNo;
    int commNo;
    String userId;
    String commMentContents;
    Timestamp commMentDate;
    Timestamp commMentUpdate;
    Integer commMentGroup_no;
    Integer commMentOrder_no;
    boolean commMentState;

    String userImg;
    List<CommunityCommentDTO> nestedList;

}
