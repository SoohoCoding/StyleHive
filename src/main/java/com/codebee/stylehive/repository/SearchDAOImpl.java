package com.codebee.stylehive.repository;


import com.codebee.stylehive.jpa.entity.*;
import com.codebee.stylehive.jpa.repository.*;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

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

    @Autowired
    public SearchDAOImpl(ProductRepo productRepo, ProductBrandRepo productBrandRepo, UserInfoRepo userInforepo, CommunityRepo communityRepo, TagRepo tagRepo, CommTagRepo commTagRepo, CommunityTagProductRepo communityTagProductRepo) {
        this.productRepo = productRepo;
        this.productBrandRepo = productBrandRepo;
        this.userInforepo = userInforepo;
        this.communityRepo = communityRepo;
        this.tagRepo = tagRepo;
        this.commTagRepo = commTagRepo;
        this.communityTagProductRepo = communityTagProductRepo;
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
        List<Integer> commNosFromTag = Collections.emptyList();

        // 태그 테이블에서 keyword와 일치하는 태그를 찾음
        TagEntity tag = tagRepo.findByTagName(keyword);

        if (tag != null) {
            // 찾은 태그의 tag_id와 일치하는 comm_tag 테이블의 comm_no 리스트를 찾음
            commNosFromTag = commTagRepo.findByTag_TagId(tag.getTagId()).stream()
                    .map(commTagEntity -> commTagEntity.getCommunity().getCommNo())
                    .collect(Collectors.toList());
        }

        // commTitle이나 commContents에서 keyword를 포함하는 커뮤니티를 찾음
        List<Integer> commNosFromContent = communityRepo.findByCommTitleContainingOrCommContentsContaining(keyword, keyword)
                .stream()
                .map(CommunityEntity::getCommNo)
                .collect(Collectors.toList());

        // 태그와 커뮤니티 내용에 해당하는 comm_no를 중복 없이 합침
        Set<Integer> combinedCommNos = new HashSet<>();
        combinedCommNos.addAll(commNosFromTag);
        combinedCommNos.addAll(commNosFromContent);

        // 합쳐진 comm_no와 일치하는 community 테이블의 커뮤니티를 찾음
        List<Integer> finalCommNos = new ArrayList<>(combinedCommNos);
        if (!finalCommNos.isEmpty()) {
            return communityRepo.findByCommNoIn(finalCommNos);
        }

        // 일치하는 결과가 없을 경우 빈 리스트 반환
        return Collections.emptyList();
    }
}