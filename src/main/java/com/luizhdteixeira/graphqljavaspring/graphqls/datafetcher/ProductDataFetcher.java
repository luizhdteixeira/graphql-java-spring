package com.luizhdteixeira.graphqljavaspring.graphqls.datafetcher;

import com.luizhdteixeira.graphqljavaspring.domains.ProductEntity;
import com.luizhdteixeira.graphqljavaspring.domains.repositories.ProductRepository;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ProductDataFetcher {

    private final ProductRepository repository;

    public ProductDataFetcher(ProductRepository repository) {
        this.repository = repository;
    }

    public DataFetcher<List<ProductEntity>> getProducts() {
        return dataFetchingEnvironment -> {
            return repository.findAll();
        };
    }

    public DataFetcher<Optional<ProductEntity>> getProductByUuid() {
        return dataFetchingEnvironment -> {
            String productUuid = dataFetchingEnvironment.getArgument("uuid");
            return repository.findById(UUID.fromString(productUuid));
        };
    }

    public DataFetcher<ProductEntity> createProduct() {
        return dataFetchingEnvironment -> {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName(dataFetchingEnvironment.getArgument("name"));
            productEntity.setValue(dataFetchingEnvironment.getArgument("value"));
            productEntity.setQuantity(dataFetchingEnvironment.getArgument("quantity"));
            return repository.save(productEntity);
        };
    }
}
