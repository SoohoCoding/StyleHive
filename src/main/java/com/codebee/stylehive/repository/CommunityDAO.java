package com.codebee.stylehive.repository;

import com.codebee.stylehive.dto.*;
import com.codebee.stylehive.jpa.entity.ImgThumbEntity;
import com.codebee.stylehive.jpa.entity.community.CommunityCommentEntity;
import com.codebee.stylehive.jpa.entity.community.CommunityEntity;

import java.util.List;

public interface CommunityDAO {
    public CommunityDTO findById(int id);
    public List<CommunityDTO> findByProductId(int productId, int size, int page);
    public List<ImgThumbEntity> findImgByCommId(int commId);
    public int countByProductId(int productId);

    public List<ProductDTO> findTagProductByCommId(int commId);

    public int findByProductCateCount(int cateId);
    public List<CommunityDTO> findByProductCate(int cateId, int size, int page);

    public int findByProductBigCateCount(List<Integer> bigCateId);
    public List<CommunityDTO> findByProductBigCate(List<Integer> bigCateId, int size, int page);

    public List<UserInfoDTO> findUserOrderByFollowCount(int size, int page);
    public List<CommunityDTO> findSummCommByUserId(String userId);

    public List<TagDTO> findTagByCommId (int commNo);
    public List<TagDTO> findBestTag (int limit);

    public int findByTagIdCount(List<Integer> tagId);

    public List<CommunityDTO> findByTagId (List<Integer> tagId, int size, int page);

    public List<CommunityCommentDTO> findCommentByCommId (int commId, int size, int page);
    public int findCommentByCommIdCount (int commId);
    public List<CommunityCommentDTO> findNestedComment(int mentNo);

    public UserInfoDTO findCommUserById(String userId);

    public List<CommunityDTO> findByUserId(String userId, int size, int page);
    public int findByUserIdCount(String userId);

    public List<CommunityDTO> findByFollow(String userId, int size, int page);
    public int findByFollowCount(String userId);

    public CommunityCommentEntity insertComment(CommunityCommentEntity comment);
}
