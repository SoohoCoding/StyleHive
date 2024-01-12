package com.codebee.stylehive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("community")
public class CommunityDTO {
    private int commNo;
    private String userId;
    private String commTitle;
    private String commContents;
    private int commCategory;
    private int commViewer;
    private Date commDate;
    private Date commUpdate;
    private boolean commState;
}
