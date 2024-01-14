package com.codebee.stylehive.dto;

import com.codebee.stylehive.jpa.entity.ImgThumbEntity;
import com.codebee.stylehive.jpa.entity.product.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private int productBrandId;
    private String productColor;
    private String productModelNum;
    private Date productDate;
    private boolean productState;

    private ProductBrandDTO productBrand;

    private List<ImgThumbEntity> productImgList = new ArrayList<>();

    private List<ProductSizeEntity> productSizeList = new ArrayList<>();

    private List<ProductDealEntity> productDealList = new ArrayList<>();

    private List<ProductTenderEntity> productTenderList = new ArrayList<>();

    @Transient
    private int wishCount;

    private int nowBuyPrice;
    private String imgUrl;
    private String productBrandEngName;

    public static ProductDTO of(ProductEntity product) {
        return new ProductDTO(
                product.getProductId(),
                product.getProductCateId(),
                product.getProductEngName(),
                product.getProductKorName(),
                product.getProductRelease(),
                product.getProductBrand().getProductBrandId(),
                product.getProductColor(),
                product.getProductModelNum(),
                product.getProductDate(),
                product.getProductState(),
                ProductBrandDTO.of(product.getProductBrand()),
                product.getProductImgList(),
                product.getProductSizeList(),
                product.getProductDealList(),
                product.getProductTenderList(),
                product.getWishCount(),
                0,
                null,
                null
        );
    }
}
