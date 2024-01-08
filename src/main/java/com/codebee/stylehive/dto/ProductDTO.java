package com.codebee.stylehive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("product")
public class ProductDTO {
    private int productId;
    private int productCateId;
    private String productEngName;
    private String productKorName;
    private String productRelease;
    private String productBrand;
    private String productColor;
    private String productSize;
    private String productModelNum;
    private String productDate;
    private String productState;
}
