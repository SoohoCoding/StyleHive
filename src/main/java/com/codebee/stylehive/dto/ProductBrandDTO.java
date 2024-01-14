package com.codebee.stylehive.dto;

import com.codebee.stylehive.jpa.entity.product.ProductBrandEntity;
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

    public static ProductBrandDTO of(ProductBrandEntity brand) {
        return new ProductBrandDTO(
          brand.getProductBrandId(),
          brand.getProductBrandEngName(),
          brand.getProductBrandKorName(),
          brand.getProductBrandImg()
        );
    }
}
