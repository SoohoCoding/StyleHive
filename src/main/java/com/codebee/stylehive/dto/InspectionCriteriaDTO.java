package com.codebee.stylehive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("inspection_criteria")
public class InspectionCriteriaDTO {
    private int inspectionNo;
    private String inspectionTitle;
    private String inspectionContent;
}
