package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.FaqEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FaqDAO {
    List<FaqEntity> getAllFaqs();
}
