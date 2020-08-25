package com.luizhdteixeira.graphqljavaspring.graphqls.services;

import com.luizhdteixeira.graphqljavaspring.graphqls.dto.ProductDTO;
import graphql.schema.DataFetchingEnvironment;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface ProductGraphqlFacadeService {

    List<ProductDTO> getProducts(DataFetchingEnvironment dfe);
    ProductDTO getProductByUuid(DataFetchingEnvironment dfe);
    ProductDTO createProduct(DataFetchingEnvironment dfe);
}
