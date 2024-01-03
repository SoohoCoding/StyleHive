package com.codebee.stylehive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspectionCriteriaDTO {
    private int inspectionNo;
    private String inspectionTitle;
    private String inspectionContent;
}
