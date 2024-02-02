package com.codebee.stylehive.controller;

import com.codebee.stylehive.service.UserFollowService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@NoArgsConstructor
@RequestMapping("/api/user/follow")
public class UserFollowController {
    UserFollowService service;
    @Autowired
    public UserFollowController(UserFollowService service) {
        this.service = service;
    }

    @PostMapping("/toggle")
    public void toggleFollowPost(@RequestParam String userId2) {
        service.follow(userId2);
    }

    @GetMapping("/toggle")
    @Transactional
    public void toggleFollowGet(@RequestParam String userId2) {
        service.follow(userId2);
    }
}
