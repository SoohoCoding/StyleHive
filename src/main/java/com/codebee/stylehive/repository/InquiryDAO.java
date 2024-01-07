package com.codebee.stylehive.repository;

import com.codebee.stylehive.jpa.entity.InquiryEntity;

public interface InquiryDAO {
    public InquiryEntity findById(int id);
}
