package com.codebee.stylehive.service;

import com.codebee.stylehive.repository.UserFollowDAO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@NoArgsConstructor
public class UserFollowServiceImpl implements UserFollowService {
    @Autowired
    private UserFollowDAO userFollowDAO;
    @Override
    @Transactional
    public void follow(String userId2) {
        userFollowDAO.follow(userId2);
    }
}
