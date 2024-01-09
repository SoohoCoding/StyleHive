package com.codebee.stylehive.service;

import com.codebee.stylehive.dto.CommunityDTO;
import com.codebee.stylehive.dto.ProductDTO;
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
        return result;
    }

    @Override
    public String findByProductIdWithCount(int productId, int limit) {
        List<CommunityDTO> result = dao.findByProductId(productId, limit);
        result.forEach(i -> {
            i.setImgList(dao.findImgByCommId(i.getCommNo()));
        });
        int count = dao.countByProductId(productId);

        Map<String, Object> map = new HashMap<>();
        map.put("commList", result);
        map.put("count", count);

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
        Map<String, Object> map = new HashMap<>();
        map.put("commList", result);
        map.put("hasNextPage", result != null ? true : false);

        return new Gson().toJson(map);
    }

}
