package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.UserInfoEntity;
import com.codebee.stylehive.jpa.entity.community.CommunityEntity;
import com.codebee.stylehive.jpa.entity.product.ProductEntity;
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
}
