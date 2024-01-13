package com.codebee.stylehive.controller;

import com.codebee.stylehive.common.FileUploadLogicService;
import com.codebee.stylehive.dto.ProductDTO;
import com.codebee.stylehive.dto.ProductDealDTO;
import com.codebee.stylehive.jpa.entity.product.ProductEntity;
import com.codebee.stylehive.service.ProductService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping("/api/product")
public class ProductContoller {


    ProductService service;
    @Autowired
    public ProductContoller(ProductService service) {
        this.service = service;
    }

    @GetMapping("/{productId}")
    public ProductEntity getById(@PathVariable("productId") int productId) {
        return service.findById(productId);
    }
    @GetMapping("/deal/{productId}")
    public List<ProductDealDTO> getDealById(@PathVariable("productId") int productId) {
        return service.findAllProductDealByProductId(productId);
    }

    @GetMapping("/another-brand/{brandId}/{limit}/{currentProductId}")
    public List<ProductDTO> getAnotherByBrandId(@PathVariable("brandId") int brandId,@PathVariable("limit") int limit, @PathVariable("currentProductId") int currentProductId) {
        return service.findProductByBrandOrderByDealCount(brandId, limit, currentProductId);
    }
}
