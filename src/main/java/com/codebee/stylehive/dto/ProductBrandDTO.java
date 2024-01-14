package com.codebee.stylehive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("product_brand")
public class ProductBrandDTO {
    private int productBrandId;
    private String productBrandEngName;
    private String productBrandKorName;
    private String productBrandImg;
}
