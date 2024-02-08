
package com.codebee.stylehive.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
@JsonIgnoreProperties({"productBrand"})
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int productId;
    int productCateId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productBrandId", referencedColumnName = "productBrandId")
    private ProductBrandEntity productBrand; // 브랜드 엔터티 참조
    String productEngName;
    String productKorName;
    String productRelease;
    String productColor;
    String productModelNum;
    Date productDate;
    boolean productState;

    @Transient
    private int minTenderPrice;
    @Transient
    private int userLikesCount;
    @Transient
    private int communityTagProductsCount;
    @Transient
    private List<ImgThumbEntity> imgList;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ProductTenderEntity> productTenderList = new ArrayList<>();
}