package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.community.CommunityEntity;
import com.codebee.stylehive.jpa.entity.product.ProductBrandEntity;
import com.codebee.stylehive.jpa.entity.product.ProductEntity;
import com.codebee.stylehive.repository.SearchDAO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.codebee.stylehive.jpa.entity.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class SearchServiceImpl implements SearchService {
    SearchDAO dao;

    @Autowired
    public SearchServiceImpl(SearchDAO dao) {
        this.dao = dao;
    }

    // 검색 통계 수집 로직
    @Override
    @Transactional
    public void logSearch(String keyword) {
        dao.logSearch(keyword);
    }

    // 상품 검색 기능
    @Override
    public List<ProductEntity> searchProducts(String keyword) {
        return dao.searchProducts(keyword);
    }

    // 유저 검색 기능
    @Override
    public List<UserInfoEntity> searchUsers(String keyword, HttpServletRequest request) {
        return dao.searchUsers(keyword, request);
    }

    // 커뮤니티 검색 기능
    @Override
    public List<CommunityEntity> searchCommunities(String keyword) {
        return dao.searchCommunities(keyword);
    }

    // 추천 상품 상위 5개
    @Override
    public List<ProductEntity> getTop5ProductsByTenderCount() {
        return dao.getTop5ProductsByTenderCount();
    }

    // 인기 검색어 상위 20개
    public List<SearchStatsEntity> getTop20PopularSearches() {
        return dao.getTop20PopularSearches();
    }

    // 인기 브랜드 상위 6개
    @Override
    public List<ProductBrandEntity> getTop6BrandsByTenderCount() {
        return dao.getTop6BrandsByTenderCount();
    }

    // 연관 검색어 상위 5개
    @Override
    public List<String> getRelatedProducts(String keyword) {
        List<ProductEntity> productEntities = dao.getRelatedProducts(keyword);

        // 언어에 따라 적절한 필드를 추출하는 함수
        Function<ProductEntity, String> productNameExtractor = productEntity -> {
            String extractedName = "ko".equals(detectLanguage(keyword)) ?
                    productEntity.getProductKorName() :
                    productEntity.getProductEngName();
            return extractedName;
        };

        // 최대 5개의 상품 검색어 추출
        List<String> limitedProductNames = productEntities.stream()
                .map(productNameExtractor)
                .filter(Objects::nonNull)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(limitedProductNames);

        // 검색어 길이 및 총 글자 수에 따라 최종 리스트를 만듦
        List<String> finalProductNames = new ArrayList<>();
        int totalLength = 0;
        for (String productName : limitedProductNames) {
            totalLength += productName.length();
            if (totalLength <= 100) {
                finalProductNames.add(productName);
            } else {
                break;
            }
        }
        System.out.println(finalProductNames);

        return finalProductNames;
    }

    // 키워드 언어 감지 메서드
    private String detectLanguage(String keyword) {
        // 키워드에 영어 알파벳이 포함되어 있다면 영어로 간주
        if (keyword.matches(".*[a-zA-Z]+.*")) {
            return "en";
        } else {
            return "ko"; // 그 외의 경우에는 한글로 간주
        }
    }

    // 자동 완성 검색어
    @Override
    public List<String> getBrandAndProductAutoComplete(String keyword) {
        List<ProductBrandEntity> brandEntities = dao.getBrandNamesAutoComplete(keyword);
        List<ProductEntity> productEntities = dao.getProductNamesAutoComplete(keyword);

        // 언어에 따라 적절한 필드를 추출하는 함수
        Function<ProductBrandEntity, String> brandNameExtractor = brandEntity -> {
            String extractedName = "ko".equals(detectLanguage(keyword)) ?
                    brandEntity.getProductBrandKorName() :
                    brandEntity.getProductBrandEngName();
            return extractedName;
        };

        Function<ProductEntity, String> productNameExtractor = productEntity -> {
            String extractedName = "ko".equals(detectLanguage(keyword)) ?
                    productEntity.getProductKorName() :
                    productEntity.getProductEngName();
            return extractedName;
        };

        // 최대 3개의 브랜드 검색어 추출
        List<String> limitedBrandNames = brandEntities.stream()
                .map(brandNameExtractor)
                .filter(Objects::nonNull)
                .limit(3)
                .collect(Collectors.toList());

        // 최대 10개의 상품 검색어 추출
        List<String> limitedProductNames = productEntities.stream()
                .map(productNameExtractor)
                .filter(Objects::nonNull)
                .limit(10)
                .collect(Collectors.toList());

        // 브랜드 검색어를 먼저 추가
        List<String> autoCompleteResults = new ArrayList<>(limitedBrandNames);
        autoCompleteResults.addAll(limitedProductNames);

        return autoCompleteResults;
    }
}
