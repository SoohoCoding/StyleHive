package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.ImgThumbEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImgThumbRepo extends JpaRepository<ImgThumbEntity, Integer> {
    List<ImgThumbEntity> findByProductId(int productId);

    List<ImgThumbEntity> findByCommNo(int commNo);

}
