package com.codebee.stylehive.repository;

import com.codebee.stylehive.dto.CommunityDTO;
import com.codebee.stylehive.dto.ProductDTO;
import com.codebee.stylehive.dto.TagDTO;
import com.codebee.stylehive.dto.UserInfoDTO;
import com.codebee.stylehive.jpa.entity.ImgThumbEntity;
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
}
