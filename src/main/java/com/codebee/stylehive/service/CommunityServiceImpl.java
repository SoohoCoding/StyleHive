package com.codebee.stylehive.service;

import com.codebee.stylehive.dto.*;
import com.codebee.stylehive.jpa.entity.community.CommunityCommentEntity;
import com.codebee.stylehive.jpa.entity.community.CommunityEntity;
import com.codebee.stylehive.repository.CommunityDAO;
import com.codebee.stylehive.util.Util;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    CommunityDAO dao;

    @Autowired
    public CommunityServiceImpl(CommunityDAO dao) {
        this.dao = dao;
    }

    @Override
    public CommunityDTO findById(int id) {
        CommunityDTO result = dao.findById(id);
        result.setImgList(dao.findImgByCommId(id));
        result.setTagProductList(dao.findTagProductByCommId(id));
        result.setTagList(dao.findTagByCommId(id));
        result.setCommentList(dao.findCommentByCommId(id, 2, 1));
        return result;
    }

    @Override
    public String findByProductIdWithCount(int productId, int size, int page) {
        List<CommunityDTO> result = dao.findByProductId(productId, size, page);
        if(result != null){
            result.forEach(i -> {
                i.setImgList(dao.findImgByCommId(i.getCommNo()));
            });
        }

        int count = dao.countByProductId(productId);
        boolean hasNextPage = count - (size * page) > 0;

        Map<String, Object> map = new HashMap<>();
        map.put("commList", result);
        map.put("count", count);
        map.put("hasNextPage", hasNextPage);

        return new Gson().toJson(map);
    }

    @Override
    public String findByProductCate(int cateId, int size, int page) {
        List<CommunityDTO> result = dao.findByProductCate(cateId, size, page);
        if(result != null) {
            result.forEach(i -> {
                i.setImgList(dao.findImgByCommId(i.getCommNo()));
            });
        }
        int count = dao.findByProductCateCount(cateId);
        boolean hasNextPage = count - (size * page) > 0;
        Map<String, Object> map = new HashMap<>();
        map.put("commList", result);
        map.put("hasNextPage", hasNextPage);

        return new Gson().toJson(map);
    }


    @Override
    public String findByProductBigCate(List<Integer> bigCateId, int size, int page) {
        List<CommunityDTO> result = dao.findByProductBigCate(bigCateId, size, page);
        if(result != null) {
            result.forEach(i -> {
                i.setImgList(dao.findImgByCommId(i.getCommNo()));
            });
        }

        int count = dao.findByProductBigCateCount(bigCateId);
        boolean hasNextPage = count - (size * page) > 0;

        Map<String, Object> map = new HashMap<>();
        map.put("commList", result);
        map.put("hasNextPage", hasNextPage);

        return new Gson().toJson(map);
    }

    @Override
    public String findCommRankDate(int size, int page) {
        List<UserInfoDTO> users = dao.findUserOrderByFollowCount(size, page);

        users.forEach(i->{
            i.setCommList(dao.findSummCommByUserId(i.getUserId()));
        });

        int maxCount = 100;
        boolean hasNextPage = maxCount - (size * page) > 0;
        hasNextPage = size > users.size() ? false : hasNextPage;
        Map<String, Object> map = new HashMap<>();
        map.put("rankData", users);
        map.put("hasNextPage", hasNextPage);
        return new Gson().toJson(map);
    }

    @Override
    public List<TagDTO> findBestTag(int limit) {
        return dao.findBestTag(limit);
    }

    @Override
    public String findByTagId(List<Integer> tagId, int size, int page) {
        List<CommunityDTO> result = dao.findByTagId(tagId, size, page);
        if(result != null) {
            result.forEach(i -> {
                i.setImgList(dao.findImgByCommId(i.getCommNo()));
            });
        }

        int count = dao.findByTagIdCount(tagId);
        boolean hasNextPage = count - (size * page) > 0;

        Map<String, Object> map = new HashMap<>();
        map.put("commList", result);
        map.put("hasNextPage", hasNextPage);

        return new Gson().toJson(map);
    }

    @Override
    public String findCommentByCommId(int commId, int size, int page) {
        List<CommunityCommentDTO> result = dao.findCommentByCommId(commId, size, page);

        if(result.size() > 0) {
            result.forEach(i -> {
                i.setNestedList(dao.findNestedComment(i.getCommMentNo()));
            });
        }

        int count = dao.findCommentByCommIdCount(commId);
        boolean hasNextPage = count - (size * page) > 0;

        Map<String, Object> map = new HashMap<>();
        map.put("mentList", result);
        map.put("hasNextPage", hasNextPage);

        return new Gson().toJson(map);
    }

    @Override
    public UserInfoDTO findCommUserById(String userId) {
        return dao.findCommUserById(userId);
    }

    @Override
    public String findByUserId(String userId, int size, int page) {
        List<CommunityDTO> result = dao.findByUserId(userId, size, page);

        if(result != null) {
            result.forEach(i -> {
                i.setImgList(dao.findImgByCommId(i.getCommNo()));
            });
        }

        int count = dao.findByUserIdCount(userId);
        boolean hasNextPage = count - (size * page) > 0;

        Map<String, Object> map = new HashMap<>();
        map.put("commList", result);
        map.put("hasNextPage", hasNextPage);

        return new Gson().toJson(map);
    }

    @Override
    public String findByFollow(String userId, int size, int page) {
        List<CommunityDTO> result = dao.findByFollow(userId, size, page);

        if(result != null) {
            result.forEach(i -> {
                i.setImgList(dao.findImgByCommId(i.getCommNo()));
            });
        }

        int count = dao.findByFollowCount(userId);
        boolean hasNextPage = count - (size * page) > 0;

        Map<String, Object> map = new HashMap<>();
        map.put("commList", result);
        map.put("hasNextPage", hasNextPage);

        return new Gson().toJson(map);
    }

    @Override
    public String insertComment(CommunityCommentEntity comment) {
        Map<String, Object> map = new HashMap<String, Object>();
        CommunityCommentEntity result = dao.insertComment(comment);
        boolean success = result != null ? true : false;
        if(success) map.put("comment", result);
        map.put("message", success ? "success" : "fail");

        return new Gson().toJson(map);
    }

}
