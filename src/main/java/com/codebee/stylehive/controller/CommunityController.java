package com.codebee.stylehive.controller;

import com.codebee.stylehive.dto.CommunityDTO;
import com.codebee.stylehive.dto.TagDTO;
import com.codebee.stylehive.dto.UserInfoDTO;
import com.codebee.stylehive.jpa.entity.community.CommunityCommentEntity;
import com.codebee.stylehive.jpa.entity.community.CommunityEntity;
import com.codebee.stylehive.service.CommunityService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping("/api/community")
public class CommunityController {

    CommunityService service;

    @Autowired
    public CommunityController(CommunityService service) {
        this.service = service;
    }

    @GetMapping("/{styleId}")
    public CommunityDTO getById(@PathVariable("styleId") int styleId) {
        return service.findById(styleId);
    }

    @GetMapping("/pid/{productId}/{size}/{page}")
    public String getByProductId(@PathVariable("productId")int productId, @PathVariable("size")int size, @PathVariable("page")int page) {
        return service.findByProductIdWithCount(productId, size, page);
    }

    @GetMapping("/pcate/{cateId}/{size}/{page}")
    public String getByProductCate(@PathVariable("cateId") int cateId, @PathVariable("size")int size, @PathVariable("page")int page) {
        return service.findByProductCate(cateId, size, page);
    }

    @GetMapping("/pbcate/{size}/{page}")
    public String getByProductCate(@RequestParam(name = "cateId") List<Integer> cateId, @PathVariable("size")int size, @PathVariable("page")int page) {
        return service.findByProductBigCate(cateId, size, page);
    }

    @GetMapping("rank/{size}/{page}")
    public String getRankData(@PathVariable("size")int size, @PathVariable("page")int page) {
        return service.findCommRankDate(size, page);
    }

    @GetMapping("best-tag/{limit}")
    public List<TagDTO> getBestTag(@PathVariable("limit") int limit) {
        return service.findBestTag(limit);
    }

    @GetMapping("/tag/{size}/{page}")
    public String getByTagId(@RequestParam(name = "tagId") List<Integer> tagId, @PathVariable("size")int size, @PathVariable("page")int page) {
        return service.findByTagId(tagId, size, page);
    }

    @GetMapping("/comment/{commId}/{size}/{page}")
    public String getCommentByCommId (@PathVariable("commId") int commId, @PathVariable("size") int size, @PathVariable("page") int page) {
        return service.findCommentByCommId(commId, size, page);
    }

    @GetMapping("/find-user/{userId}")
    public UserInfoDTO getUserById (@PathVariable("userId")String userId) {
        return service.findCommUserById(userId);
    }

    @GetMapping("/uid/{userId}/{size}/{page}")
    public String getByUserId (@PathVariable("userId") String userId, @PathVariable("size") int size, @PathVariable("page") int page) {
        return service.findByUserId(userId,size, page);
    }

    @GetMapping("/follow/{size}/{page}")
    public String getByFollow (@PathVariable("size") int size, @PathVariable("page") int page) {
        //TODO log-in 처리 이후에 userId값을 로그인 정보에서 받아와야함.
        return service.findByFollow("test",size, page);
    }

    @PostMapping("/comment/write")
    public String writeComment(@RequestBody CommunityCommentEntity comment) {
        //TODO log - in
        comment.setUserId("test");
        return service.insertComment(comment);
    }
}
