package com.codebee.stylehive.repository;


import com.codebee.stylehive.jpa.entity.*;
import com.codebee.stylehive.jpa.repository.*;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.*;
import java.util.stream.Collectors;



@Repository
@NoArgsConstructor
public class SearchDAOImpl implements SearchDAO {
    ProductRepo productRepo;
    ProductBrandRepo productBrandRepo;
    UserInfoRepo userInforepo;
    CommunityRepo communityRepo;
    TagRepo tagRepo;
    CommTagRepo commTagRepo;
    CommunityTagProductRepo communityTagProductRepo;
    ProductTenderRepo productTenderRepo;

    @Autowired
    public SearchDAOImpl(ProductRepo productRepo, ProductBrandRepo productBrandRepo, UserInfoRepo userInforepo, CommunityRepo communityRepo, TagRepo tagRepo, CommTagRepo commTagRepo, CommunityTagProductRepo communityTagProductRepo, ProductTenderRepo productTenderRepo) {
        this.productRepo = productRepo;
        this.productBrandRepo = productBrandRepo;
        this.userInforepo = userInforepo;
        this.communityRepo = communityRepo;
        this.tagRepo = tagRepo;
        this.commTagRepo = commTagRepo;
        this.communityTagProductRepo = communityTagProductRepo;
        this.productTenderRepo = productTenderRepo;
    };

    // 상품 검색 기능
    @Override
    public List<ProductEntity> searchProducts(String keyword) {
        // 브랜드명으로 검색하여 brandIds를 가져옴
        List<ProductBrandEntity> brandEntities = productBrandRepo.findByProductBrandEngNameContainingOrProductBrandKorNameContaining(keyword, keyword);

        // brandIds를 추출하여 해당 브랜드의 상품을 검색
        List<Integer> brandIds = brandEntities.stream().map(ProductBrandEntity::getProductBrandId).collect(Collectors.toList());

        return productRepo.findByProductEngNameContainingOrProductKorNameContainingOrProductBrand_ProductBrandIdIn(
                keyword, keyword, brandIds
        );
    }

    // 유저 검색 기능
    @Override
    public List<UserInfoEntity> searchUsers(String keyword) {
        return userInforepo.findByUserNameContainingOrUserNicknameContainingOrUserIntroduceContaining(keyword, keyword, keyword);
    }

    // 커뮤니티 검색 기능
    @Override
    public List<CommunityEntity> searchCommunities(String keyword) {
        // 1. 상품 태그
        // 브랜드명으로 검색하여 brandIds를 가져옴
        List<ProductBrandEntity> brandEntities = productBrandRepo.findByProductBrandEngNameContainingOrProductBrandKorNameContaining(keyword, keyword);

        // brandIds를 추출하여 해당 브랜드의 상품을 검색
        List<Integer> brandIds = brandEntities.stream().map(ProductBrandEntity::getProductBrandId).collect(Collectors.toList());

        // 검색된 상품의 productId를 사용하여 communityTagProduct 테이블에서 comm_no를 찾음
        List<Integer> commNosFromProduct = communityTagProductRepo.findByProduct_ProductIdIn(
                        productRepo.findByProductEngNameContainingOrProductKorNameContainingOrProductBrand_ProductBrandIdIn(
                                keyword, keyword, brandIds
                        ).stream().map(ProductEntity::getProductId).collect(Collectors.toList())
                ).stream()
                .map(CommunityTagProductEntity -> CommunityTagProductEntity.getCommunity().getCommNo())
                .collect(Collectors.toList());

        // 2. 태그 테이블에서 keyword와 일치하는 태그를 찾음
        TagEntity tag = tagRepo.findByTagName(keyword);
        List<Integer> commNosFromTag = Collections.emptyList();

        if (tag != null) {
            // 찾은 태그의 tag_id와 일치하는 comm_tag 테이블의 comm_no 리스트를 찾음
            commNosFromTag = commTagRepo.findByTag_TagId(tag.getTagId()).stream()
                    .map(commTagEntity -> commTagEntity.getCommunity().getCommNo())
                    .collect(Collectors.toList());
        }

        // 3. commTitle이나 commContents에서 keyword를 포함하는 커뮤니티를 찾음
        List<Integer> commNosFromContent = communityRepo.findByCommTitleContainingOrCommContentsContaining(keyword, keyword)
                .stream()
                .map(CommunityEntity::getCommNo)
                .collect(Collectors.toList());

        // 태그와 커뮤니티 내용에 해당하는 comm_no를 중복 없이 합침
        Set<Integer> combinedCommNos = new HashSet<>();
        combinedCommNos.addAll(commNosFromTag);
        combinedCommNos.addAll(commNosFromContent);
        combinedCommNos.addAll(commNosFromProduct);

        // 합쳐진 comm_no와 일치하는 community 테이블의 커뮤니티를 찾음
        List<Integer> finalCommNos = new ArrayList<>(combinedCommNos);
        if (!finalCommNos.isEmpty()) {
            return communityRepo.findByCommNoIn(finalCommNos);
        }

        // 일치하는 결과가 없을 경우 빈 리스트 반환
        return Collections.emptyList();
    }

    // 인기 상품 상위 10개
    @Override
    public List<ProductEntity> getTop10ProductsByTenderCount() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -7);

        Date oneWeekAgoDate = new Date(calendar.getTimeInMillis());

        List<Object[]> top10ProductIds = productTenderRepo.findTop10MostTenderedProductIdsInLastWeek(oneWeekAgoDate);

        List<Integer> productIdList = top10ProductIds.stream()
                .map(objects -> ((Number) objects[0]).intValue())
                .collect(Collectors.toList());

        return productRepo.findByProductIdIn(productIdList);
    }

    // 인기 브랜드 상위 10개
    @Override
    public List<ProductBrandEntity> getTop10BrandsByTenderCount() {
        List<Object[]> result = productTenderRepo.findTop10BrandsByTenderCountCustomQuery();

        List<ProductBrandEntity> topBrands = new ArrayList<>();

        for (Object[] row : result) {
            ProductBrandEntity brand = (ProductBrandEntity) row[0];
            topBrands.add(brand);
        }

        return topBrands;
    }

}