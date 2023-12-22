package com.codebee.stylehive.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping(value = {"/", "/product/**", "/style/**"})
    public String frontView() {
        return "forward:/index.html";
    }

}
