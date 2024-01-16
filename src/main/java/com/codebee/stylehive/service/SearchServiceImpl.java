package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.*;
import com.codebee.stylehive.repository.SearchDAO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public List<UserInfoEntity> searchUsers(String keyword) {
        return dao.searchUsers(keyword);
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
}
