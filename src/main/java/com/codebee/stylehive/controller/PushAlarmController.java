package com.codebee.stylehive.controller;

import com.codebee.stylehive.jpa.entity.PushAlarmEntity;
import com.codebee.stylehive.service.PushAlarmService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@NoArgsConstructor
public class PushAlarmController {

    PushAlarmService service;

    @Autowired
    public PushAlarmController(PushAlarmService service) {
        this.service = service;
    }

    @GetMapping("/pushtest")
    public List<PushAlarmEntity> findAll(){
        System.out.println(service.findAll());
        return service.findAll();
    }
}
