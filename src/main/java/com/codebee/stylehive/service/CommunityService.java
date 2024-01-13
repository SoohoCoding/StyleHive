package com.codebee.stylehive.service;

import com.codebee.stylehive.dto.*;
import com.codebee.stylehive.jpa.entity.community.CommunityEntity;

import java.util.List;

public interface CommunityService {
    public CommunityDTO findById(int id);
    public String findByProductIdWithCount(int productId, int size, int page);
    public String findByProductCate(int cateId, int size, int page);

    public String findByProductBigCate(List<Integer> bigCateId, int size, int page);

    public String findCommRankDate(int size, int page);
    public List<TagDTO> findBestTag(int limit);

    public String findByTagId (List<Integer> tagId, int size, int page);
    public String findCommentByCommId (int commId, int size, int page);

    public UserInfoDTO findCommUserById(String userId);
    public String findByUserId(String userId, int size, int page);

    public String findByFollow(String userId, int size, int page);
}
