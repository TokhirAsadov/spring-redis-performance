package com.tohir.redisperformance.controller;

import com.tohir.redisperformance.entity.Product;
import com.tohir.redisperformance.service.ProductServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("product/v1")
@RequiredArgsConstructor
public class ProductController1 {
    private final ProductServiceV1 service;

    @GetMapping("{id}")
    public Mono<Product> getProduct(@PathVariable int id){
        return service.getProduct(id);
    }

    @PutMapping("{id}")
    public Mono<Product> updateProduct(@PathVariable int id,@RequestBody Mono<Product> productMono){
        return service.updateProduct(id,productMono);
    }

}
