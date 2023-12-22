package com.codebee.stylehive.controller;

import com.codebee.stylehive.jpa.repository.TestRepo;
import com.codebee.stylehive.jpa.repository.UserCouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping(value = {"/", "/product/**", "/style/**"})
    public String frontView() {
        return "forward:/index.html";
    }

}
