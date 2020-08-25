package com.luizhdteixeira.graphqljavaspring.domains.services.impl;

import com.luizhdteixeira.graphqljavaspring.domains.ProductEntity;
import com.luizhdteixeira.graphqljavaspring.domains.repositories.ProductRepository;
import com.luizhdteixeira.graphqljavaspring.domains.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductEntity> getProducts() {
        return repository.findAll();
    }

    @Override
    public Optional<ProductEntity> getProductByUuid(UUID uuid) {
        return repository.findById(uuid);
    }

    @Override
    public ProductEntity createProduct(ProductEntity productEntity) {
        return repository.save(productEntity);
    }
}
