package com.codebee.stylehive.controller;

import com.codebee.stylehive.common.FileUploadLogicService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.MalformedURLException;

@Controller
@NoArgsConstructor
public class ViewController {

    FileUploadLogicService fileUpload;

    @Autowired
    public ViewController(FileUploadLogicService fileUpload) {
        this.fileUpload = fileUpload;
    }

    @GetMapping(value = {"/", "/product/**", "/style/**"})
    public String frontView() {
        return "forward:/index.html";
    }

    @RequestMapping("/api/get-image/{path}/{name}")
    public ResponseEntity<UrlResource> getProductImage(@PathVariable String path, @PathVariable String name) throws MalformedURLException {
        UrlResource resource = new UrlResource("file:"+fileUpload.getUploadpath(path,name));

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(resource);
    }

}
