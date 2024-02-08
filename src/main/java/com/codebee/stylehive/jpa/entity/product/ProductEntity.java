package com.codebee.stylehive.jpa.entity.product;

import com.codebee.stylehive.jpa.entity.ImgThumbEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int productId;
    int productCateId;
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

    public boolean getProductState() {return this.productState;}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productBrandId", referencedColumnName = "productBrandId")
    private ProductBrandEntity productBrand;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private List<ImgThumbEntity> productImgList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private List<ProductSizeEntity> productSizeList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    @SQLRestriction("deal_progress = 'done'")
    private List<ProductDealEntity> productDealList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private List<ProductTenderEntity> productTenderList = new ArrayList<>();

    //@Transient
    //private List<ProductWishCountDTO> productWishCountList;

    @Transient
    private int wishCount;
}
