package com.codebee.stylehive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("productDeal")
public class ProductDealDTO {
    int dealId;
    int productId;
    String dealSellID;
    String dealBuyID;
    String dealProgress;
    String dealPayment;
    int dealPrice;
    Timestamp dealDate;
    int dealInspectionId;
    int couId;
}
