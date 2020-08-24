package com.luizhdteixeira.graphqljavaspring.graphqls.services.impl;

import com.luizhdteixeira.graphqljavaspring.domains.mappers.ProductMapper;
import com.luizhdteixeira.graphqljavaspring.domains.services.ProductService;
import com.luizhdteixeira.graphqljavaspring.graphqls.dto.ProductDTO;
import com.luizhdteixeira.graphqljavaspring.graphqls.services.ProductGraphqlFacadeService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductGraphqlFacadeServiceImpl implements ProductGraphqlFacadeService {

    private final ProductService productService;
    private final ProductMapper mapper;

    public ProductGraphqlFacadeServiceImpl(ProductService productService, ProductMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }


    @Override
    public List<ProductDTO> getProducts(DataFetchingEnvironment dfe) {
        return null;
    }

    @Override
    public Optional<ProductDTO> getProductByUuid(DataFetchingEnvironment dfe) {
        return Optional.empty();
    }

    @Override
    public ProductDTO createProduct(DataFetchingEnvironment dfe) {
        return null;
    }
}
