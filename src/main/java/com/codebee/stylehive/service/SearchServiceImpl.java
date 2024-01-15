package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.CommunityEntity;
import com.codebee.stylehive.jpa.entity.ProductBrandEntity;
import com.codebee.stylehive.jpa.entity.ProductEntity;
import com.codebee.stylehive.jpa.entity.UserInfoEntity;
import com.codebee.stylehive.repository.SearchDAO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class SearchServiceImpl implements SearchService {
    SearchDAO dao;

    @Autowired
    public SearchServiceImpl(SearchDAO dao) {
        this.dao = dao;
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

    // 인기 상품 상위 10개
    @Override
    public List<ProductEntity> getTop10ProductsByTenderCount() {
        return dao.getTop10ProductsByTenderCount();
    }

    // 인기 브랜드 상위 10개
    @Override
    public List<ProductBrandEntity> getTop10BrandsByTenderCount() {
        return dao.getTop10BrandsByTenderCount();
    }
}
