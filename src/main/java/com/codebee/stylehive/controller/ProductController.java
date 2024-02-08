package com.codebee.stylehive.controller;

import com.codebee.stylehive.dto.ProductBrandDTO;
import com.codebee.stylehive.dto.ProductDTO;
import com.codebee.stylehive.dto.ProductDealDTO;
import com.codebee.stylehive.jpa.entity.product.ProductEntity;
import com.codebee.stylehive.service.ProductService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping("/api/product")
public class ProductController {


    ProductService service;
    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/{productId}")
    public ProductDTO getById(@PathVariable("productId") int productId) {
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

    @GetMapping("/find-keyword/{keyword}/{size}/{page}")
    public String getProductByKeyword(@PathVariable("keyword") String keyword, @PathVariable("size")int size, @PathVariable("page") int page) {
        return service.findProductByKeyword(keyword, size, page);
    }

    @GetMapping("/sort-date/{size}/{page}")
    public String getProductSortDate(@PathVariable("size")int size, @PathVariable("page") int page) {
        return service.findProductSortDate(size, page);
    }

    @GetMapping("top10-brand")
    public List<ProductBrandDTO> findTop10Brand() {
        return service.findTop10Brand();
    }

    @GetMapping("top8-product")
    public List<ProductDTO> findTop8Product() {
        return service.findTop8Product();
    }

}
