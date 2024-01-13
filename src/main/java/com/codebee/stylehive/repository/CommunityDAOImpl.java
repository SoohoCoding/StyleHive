package com.codebee.stylehive.repository;

import com.codebee.stylehive.dto.*;
import com.codebee.stylehive.jpa.entity.ImgThumbEntity;
import com.codebee.stylehive.jpa.entity.community.CommunityCommentEntity;
import com.codebee.stylehive.jpa.entity.community.CommunityEntity;
import com.codebee.stylehive.jpa.repository.CommunityCommentRepo;
import com.codebee.stylehive.jpa.repository.CommunityRepo;
import com.codebee.stylehive.util.Util;
import lombok.NoArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Repository
public class CommunityDAOImpl implements CommunityDAO {

    CommunityRepo repo;
    CommunityCommentRepo commentRepo;
    SqlSession ss;

    @Autowired
    public CommunityDAOImpl(CommunityRepo repo, CommunityCommentRepo commentRepo, SqlSession ss) {
        this.repo = repo;
        this.commentRepo = commentRepo;
        this.ss = ss;
    }

    @Override
    public CommunityDTO findById(int id) {
        return this.ss.selectOne("com.codebee.stylehive.community.selectById", id);
    }

    @Override
    public List<CommunityDTO> findByProductId(int productId, int size, int page) {
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("productId", productId);
        Util.addPageParam(paramMap, size, page);
        return ss.selectList("com.codebee.stylehive.community.selectByProductId", paramMap);
    }

    @Override
    public List<ImgThumbEntity> findImgByCommId(int commId) {
        return ss.selectList("com.codebee.stylehive.community.selectImgById", commId);
    }

    @Override
    public int countByProductId(int productId) {
        return ss.selectOne("com.codebee.stylehive.community.countByProductId", productId);
    }

    @Override
    public List<ProductDTO> findTagProductByCommId(int commId) {
        return ss.selectList("com.codebee.stylehive.community.selectTagProductById", commId);
    }

    @Override
    public int findByProductCateCount(int cateId) {
        return ss.selectOne("com.codebee.stylehive.community.selectProductCateCount", cateId);
    }

    @Override
    public List<CommunityDTO> findByProductCate(int cateId, int size, int page) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("cateId", cateId);
        Util.addPageParam(map, size, page);
        return ss.selectList("com.codebee.stylehive.community.selectProductCate", map);
    }

    @Override
    public int findByProductBigCateCount(List<Integer> bigCateId) {
        return ss.selectOne("com.codebee.stylehive.community.selectProductBigCateCount", bigCateId);
    }

    @Override
    public List<CommunityDTO> findByProductBigCate(List<Integer> bigCateId, int size, int page) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("cateId", bigCateId);
        Util.addPageParam(map, size, page);
        return ss.selectList("com.codebee.stylehive.community.selectProductBigCate", map);
    }

    @Override
    public List<UserInfoDTO> findUserOrderByFollowCount(int size, int page) {
        Map<String, Object> map = new HashMap<>();
        Util.addPageParam(map, size, page);
        return ss.selectList("com.codebee.stylehive.community.selectUserOrderByFollowCount", map);
    }

    @Override
    public List<CommunityDTO> findSummCommByUserId(String userId) {
        return ss.selectList("com.codebee.stylehive.community.selectSummCommByUserId", userId);
    }

    @Override
    public List<TagDTO> findTagByCommId(int commNo) {
        return ss.selectList("com.codebee.stylehive.community.selectTagByCommId", commNo);
    }

    @Override
    public List<TagDTO> findBestTag(int limit) {
        return ss.selectList("com.codebee.stylehive.community.selectBestTag", limit);
    }

    @Override
    public int findByTagIdCount(List<Integer> tagId) {
        return ss.selectOne("com.codebee.stylehive.community.countByTagId", tagId);
    }

    @Override
    public List<CommunityDTO> findByTagId(List<Integer> tagId, int size, int page) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tagId", tagId);
        Util.addPageParam(map, size, page);
        return ss.selectList("com.codebee.stylehive.community.selectByTagId",map);
    }

    @Override
    public List<CommunityCommentDTO> findCommentByCommId(int commId, int size, int page) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("commId", commId);
        Util.addPageParam(map, size, page);
        return ss.selectList("com.codebee.stylehive.community.selectCommentByCommId", map);
    }

    @Override
    public int findCommentByCommIdCount(int commId) {
        return ss.selectOne("com.codebee.stylehive.community.selectCommentByCommIdCount", commId);
    }

    @Override
    public List<CommunityCommentDTO> findNestedComment(int mentNo) {
        return ss.selectList("com.codebee.stylehive.community.selectNestedComment", mentNo);
    }

    @Override
    public UserInfoDTO findCommUserById(String userId) {
        return ss.selectOne("com.codebee.stylehive.community.selectCommUserById", userId);
    }

    @Override
    public List<CommunityDTO> findByUserId(String userId, int size, int page) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", userId);
        Util.addPageParam(map, size, page);
        return ss.selectList("com.codebee.stylehive.community.selectByUserId", map);
    }

    @Override
    public int findByUserIdCount(String userId) {
        return ss.selectOne("com.codebee.stylehive.community.selectByUserIdCount", userId);
    }

    @Override
    public List<CommunityDTO> findByFollow(String userId, int size, int page) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", userId);
        Util.addPageParam(map, size, page);
        return ss.selectList("com.codebee.stylehive.community.selectByFollow", map);
    }

    @Override
    public int findByFollowCount(String userId) {
        return ss.selectOne("com.codebee.stylehive.community.selectByFollowCount", userId);
    }

    @Override
    public CommunityCommentEntity insertComment(CommunityCommentEntity comment) {
        return commentRepo.save(comment);
    }


}
