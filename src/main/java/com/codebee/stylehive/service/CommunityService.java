package com.codebee.stylehive.service;

import com.codebee.stylehive.dto.CommunityDTO;
import com.codebee.stylehive.dto.ProductDTO;
import com.codebee.stylehive.dto.ProductDealDTO;
import com.codebee.stylehive.jpa.entity.community.CommunityEntity;

import java.util.List;

public interface CommunityService {
    public CommunityDTO findById(int id);
    public String findByProductIdWithCount(int productId, int limit);
    public String findByProductCate(int cateId, int size, int page);
}
