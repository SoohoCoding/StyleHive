package com.codebee.stylehive.dto;

import com.codebee.stylehive.jpa.entity.product.ProductBrandEntity;
import lombok.*;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Alias("product_brand")
public class ProductBrandDTO {
    @NonNull
    private int productBrandId;
    @NonNull
    private String productBrandEngName;
    @NonNull
    private String productBrandKorName;
    @NonNull
    private String productBrandImg;


    private int dealCount;
    public static ProductBrandDTO of(ProductBrandEntity brand) {
        return new ProductBrandDTO(
          brand.getProductBrandId(),
          brand.getProductBrandEngName(),
          brand.getProductBrandKorName(),
          brand.getProductBrandImg()
        );
    }
}
