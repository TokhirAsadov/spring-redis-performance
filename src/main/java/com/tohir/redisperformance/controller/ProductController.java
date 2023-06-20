package com.tohir.redisperformance.controller;

import com.tohir.redisperformance.entity.Product;
import com.tohir.redisperformance.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("{id}")
    public Mono<Product> getProduct(@PathVariable int id){
        return service.getProduct(id);
    }


}
