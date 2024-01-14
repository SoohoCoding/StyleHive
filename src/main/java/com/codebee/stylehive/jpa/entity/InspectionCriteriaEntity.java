package com.codebee.stylehive.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inspection_criteria")
public class InspectionCriteriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int inspectionNo;
    String inspectionTitle;
    String inspectionContent;
}
