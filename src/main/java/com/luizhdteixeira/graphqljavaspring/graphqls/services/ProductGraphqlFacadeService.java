package com.luizhdteixeira.graphqljavaspring.graphqls.services;

import com.luizhdteixeira.graphqljavaspring.graphqls.dto.ProductDTO;
import graphql.schema.DataFetchingEnvironment;

import java.util.List;
import java.util.Optional;

public interface ProductGraphqlFacadeService {

    List<ProductDTO> getProducts(DataFetchingEnvironment dfe);
    Optional<ProductDTO> getProductByUuid(DataFetchingEnvironment dfe);
    ProductDTO createProduct(DataFetchingEnvironment dfe);
}
