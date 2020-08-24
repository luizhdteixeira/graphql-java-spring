package com.luizhdteixeira.graphqljavaspring.domains.services;

import com.luizhdteixeira.graphqljavaspring.domains.ProductEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {

    List<ProductEntity> getProducts();
    Optional<ProductEntity> getProductByUuid(UUID uuid);
    ProductEntity createProduct(ProductEntity productEntity);
}
