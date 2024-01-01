package com.codebee.stylehive.jpa.entity.product;

import com.codebee.stylehive.dto.ProductWishCountDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
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
    int productBrandId;
    String productEngName;
    String productKorName;
    String productRelease;
    String productColor;
    String productModelNum;
    Date productDate;
    boolean productState;

    @ManyToOne
    @JoinColumn(name = "productBrandId", insertable = false, updatable = false)
    private ProductBrandEntity brand;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private List<ProductImgEntity> productImgList = new ArrayList<>();

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
