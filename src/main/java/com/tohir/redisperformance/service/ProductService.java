package com.tohir.redisperformance.service;

import com.tohir.redisperformance.entity.Product;
import com.tohir.redisperformance.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public Mono<Product> getProduct(int id) {
        return repository.findById(id);
    }

    public Mono<Product> updateProduct(int id,Mono<Product> productMono){
        return repository.findById(id)
                .flatMap(p->productMono.doOnNext(pr->pr.setId(id)))
                .flatMap(repository::save);
    }


}
