package com.codebee.stylehive.service;

import com.codebee.stylehive.jpa.entity.InquiryEntity;


public interface InquiryService{
    public InquiryEntity findById(int id);
}