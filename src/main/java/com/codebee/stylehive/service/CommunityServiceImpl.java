package com.codebee.stylehive.service;

import com.codebee.stylehive.dto.CommunityDTO;
import com.codebee.stylehive.dto.ProductDTO;
import com.codebee.stylehive.dto.TagDTO;
import com.codebee.stylehive.dto.UserInfoDTO;
import com.codebee.stylehive.jpa.entity.community.CommunityEntity;
import com.codebee.stylehive.repository.CommunityDAO;
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

}
