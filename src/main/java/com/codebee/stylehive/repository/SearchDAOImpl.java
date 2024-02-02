package com.codebee.stylehive.repository;


import com.codebee.stylehive.jpa.entity.*;
import com.codebee.stylehive.jpa.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.*;
import java.util.stream.Collectors;



@Repository
@NoArgsConstructor
public class SearchDAOImpl implements SearchDAO {
    @PersistenceContext
    private EntityManager entityManager;

    ProductRepo productRepo;
    ProductBrandRepo productBrandRepo;
    UserInfoRepo userInforepo;
    CommunityRepo communityRepo;
    TagRepo tagRepo;
    CommTagRepo commTagRepo;
    CommunityTagProductRepo communityTagProductRepo;
    ProductTenderRepo productTenderRepo;
    SearchStatsRepo searchStatsRepo;
     UserLikeRepo userLikeRepo;
     UserFollowRepo userFollowRepo;
     ImgThumbRepo imgThumbRepo;
     CommunityLikeRepo communityLikeRepo;

    @Autowired
    public SearchDAOImpl(ProductRepo productRepo, ProductBrandRepo productBrandRepo, UserInfoRepo userInforepo,
                         CommunityRepo communityRepo, TagRepo tagRepo, CommTagRepo commTagRepo,
                         CommunityTagProductRepo communityTagProductRepo, ProductTenderRepo productTenderRepo,
                         SearchStatsRepo searchStatsRepo, UserLikeRepo userLikeRepo, UserFollowRepo userFollowRepo,
                         ImgThumbRepo imgThumbRepo, CommunityLikeRepo communityLikeRepo) {
        this.productRepo = productRepo;
        this.productBrandRepo = productBrandRepo;
        this.userInforepo = userInforepo;
        this.communityRepo = communityRepo;
        this.tagRepo = tagRepo;
        this.commTagRepo = commTagRepo;
        this.communityTagProductRepo = communityTagProductRepo;
        this.productTenderRepo = productTenderRepo;
        this.searchStatsRepo = searchStatsRepo;
        this.userLikeRepo = userLikeRepo;
        this.userFollowRepo = userFollowRepo;
        this.imgThumbRepo = imgThumbRepo;
        this.communityLikeRepo = communityLikeRepo;
    };

    // 검색 통계 수집 로직
    @Override
    public void logSearch(String keyword) {
        // 검색어가 존재하는지 확인
        SearchStatsEntity existingSearch = entityManager.createQuery("SELECT s FROM SearchStatsEntity s WHERE s.keyword = :keyword", SearchStatsEntity.class)
                .setParameter("keyword", keyword)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);

        if (existingSearch == null) {
            // 검색어가 존재하지 않으면 새로운 엔티티를 생성하고 저장
            SearchStatsEntity newSearch = new SearchStatsEntity();
            newSearch.setKeyword(keyword);
            newSearch.setSearchCount(1);  // 처음 검색된 경우 초기 카운트 값을 설정하십시오.
            entityManager.persist(newSearch);
        } else {
            // 검색어가 이미 존재하면 카운트를 증가시킴
            existingSearch.setSearchCount(existingSearch.getSearchCount() + 1);
        }
    }

    // 상품 검색 기능
    @Override
    public List<ProductEntity> searchProducts(String keyword) {
        // 브랜드명으로 검색하여 brandIds를 가져옴
        List<ProductBrandEntity> brandEntities = productBrandRepo.findByProductBrandEngNameContainingOrProductBrandKorNameContaining(keyword, keyword);

        // brandIds를 추출하여 해당 브랜드의 상품을 검색
        List<Integer> brandIds = brandEntities.stream().map(ProductBrandEntity::getProductBrandId).collect(Collectors.toList());

        List<ProductEntity> products = productRepo.findByProductEngNameContainingOrProductKorNameContainingOrProductBrand_ProductBrandIdIn(
                keyword, keyword, brandIds
        );

        List<ProductEntity> filteredProducts = new ArrayList<>();

        for (ProductEntity product : products) {
            boolean tenderExists = productTenderRepo.existsByProduct_ProductId(product.getProductId());

            if (tenderExists) {
                product.setMinTenderPrice(productTenderRepo.findMinTenderPriceByProduct_ProductId(product));
                product.setUserLikesCount(userLikeRepo.countByProduct(product));
                product.setCommunityTagProductsCount(communityTagProductRepo.countByProduct(product));

                // 이미지 썸네일을 가져옴
                List<ImgThumbEntity> imgThumbs = imgThumbRepo.findByProductId(product.getProductId());
                if (imgThumbs != null) {
                    product.setImgList(imgThumbs);
                } else {
                    // 이미지가 없는 경우 빈 리스트 설정
                    product.setImgList(Collections.emptyList());
                }
                //product.setImgThumbnails(imgThumbRepo.findByProductId(product.getProductId()));

                filteredProducts.add(product);
            }
        }

        return filteredProducts;
    }

    // 현재 사용자의 user_id를 얻는 메서드
    private String getCurrentUserId(HttpServletRequest request) {
        // HttpSession을 통해 현재 사용자의 세션을 가져옵니다.
        HttpSession session = request.getSession(false);

        // 세션이 존재하고, 세션에 사용자 정보가 저장되어 있는지 확인합니다.
        if (session != null && session.getAttribute("userId") != null) {
            // 세션에 저장된 user_id를 반환합니다.
            return (String) session.getAttribute("userId");
        } else {
            // 세션이나 사용자 정보가 없는 경우, null을 반환하거나 예외를 처리할 수 있습니다.
            return null;
        }
    }

    // 유저 검색 기능
    @Override
    public List<UserInfoEntity> searchUsers(String keyword, HttpServletRequest request) {
        List<UserInfoEntity> users = userInforepo.findByUserNameContainingOrUserNicknameContainingOrUserIntroduceContaining(keyword, keyword, keyword);

        // 현재 사용자의 user_id를 얻어옵니다.
        String currentUserId = getCurrentUserId(request);

        // 찾은 유저들 중 현재 사용자가 팔로우하고 있는지 여부를 확인합니다.
        for (UserInfoEntity user : users) {
            user.setUserFollowsCount(userFollowRepo.countByUserId2(user.getUserId()));
            if (currentUserId != null) {
                user.setLoggedInUserId(currentUserId);
                user.setIsFollowing(userFollowRepo.existsByUserIdAndUserId2(currentUserId, user.getUserId()));
            } else {
                user.setIsFollowing(false);
            }
        }

        return users;
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
            List<CommunityEntity> communities = communityRepo.findByCommNoIn(finalCommNos);

            for (CommunityEntity community : communities) {
                community.setLikeCount(communityLikeRepo.countByCommNo(community.getCommNo()));
                community.setUserImg(userInforepo.findByUserId(community.getUserId()).getUserImg());

                // 이미지 썸네일을 가져옴
                List<ImgThumbEntity> imgThumbs = imgThumbRepo.findByCommNo(community.getCommNo());
                if (imgThumbs != null) {
                    community.setImgList(imgThumbs);
                } else {
                    // 이미지가 없는 경우 빈 리스트 설정
                    community.setImgList(Collections.emptyList());
                }
            }

            return communities;
        }

        // 일치하는 결과가 없을 경우 빈 리스트 반환
        return Collections.emptyList();
    }

    // 추천 상품 상위 5개
    @Override
    public List<ProductEntity> getTop5ProductsByTenderCount() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -7);

        Date oneWeekAgoDate = new Date(calendar.getTimeInMillis());

        List<Object[]> top5ProductIds = productTenderRepo.findTop5MostTenderedProductIdsInLastWeek(oneWeekAgoDate);

        List<Integer> productIdList = top5ProductIds.stream()
                .map(objects -> ((Number) objects[0]).intValue())
                .collect(Collectors.toList());

        return productRepo.findByProductIdIn(productIdList);
    }

    // 인기 검색어 상위 20개
    public List<SearchStatsEntity> getTop20PopularSearches() {
        return searchStatsRepo.findPopularSearches();
    }

    // 인기 브랜드 상위 6개
    @Override
    public List<ProductBrandEntity> getTop6BrandsByTenderCount() {
        List<Object[]> result = productTenderRepo.findTop6BrandsByTenderCountCustomQuery();

        List<ProductBrandEntity> topBrands = new ArrayList<>();

        for (Object[] row : result) {
            ProductBrandEntity brand = (ProductBrandEntity) row[0];
            topBrands.add(brand);
        }

        return topBrands;
    }

    // 연관 검색어 상위 5개
    @Override
    public List<ProductEntity> getRelatedProducts(String keywords) {
        List<String> searchKeywords = List.of(keywords.split("\\s+"));

        if (searchKeywords.isEmpty()) {
            // 검색어가 없는 경우 빈 리스트 반환
            return List.of();
        } else {
            // 첫 번째 키워드에 대한 검색을 기본으로 수행
            String firstKeyword = searchKeywords.get(0);
            List<ProductEntity> result = productRepo.findByProductEngNameContainingOrProductKorNameContaining(firstKeyword, firstKeyword);

            // 나머지 키워드에 대한 검색을 추가
            for (int i = 1; i < searchKeywords.size(); i++) {
                String keyword = searchKeywords.get(i);
                result.addAll(productRepo.findByProductEngNameContainingOrProductKorNameContaining(keyword, keyword));
            }

            // 중복 제거 후 결과를 최대 5개로 제한
            return result.stream()
                    .distinct()
                    .limit(5)
                    .collect(Collectors.toList());
        }
    }

    // 브랜드 자동 완성 검색어
    @Override
    public List<ProductBrandEntity> getBrandNamesAutoComplete(String keyword) {
        return productBrandRepo.findByProductBrandEngNameContainingOrProductBrandKorNameContaining(keyword, keyword);
    }

    // 상품 이름 자동 완성 검색어
    @Override
    public List<ProductEntity> getProductNamesAutoComplete(String keyword) {
        return productRepo.findByProductEngNameContainingOrProductKorNameContaining(keyword, keyword);
    }
}