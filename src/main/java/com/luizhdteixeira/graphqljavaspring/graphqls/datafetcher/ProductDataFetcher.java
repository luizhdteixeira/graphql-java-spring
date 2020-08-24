package com.luizhdteixeira.graphqljavaspring.graphqls.datafetcher;

import com.luizhdteixeira.graphqljavaspring.graphqls.dto.ProductDTO;
import com.luizhdteixeira.graphqljavaspring.graphqls.services.ProductGraphqlFacadeService;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductDataFetcher {

    private final ProductGraphqlFacadeService productGraphqlFacadeService;

    public ProductDataFetcher(ProductGraphqlFacadeService productGraphqlFacadeService) {
        this.productGraphqlFacadeService = productGraphqlFacadeService;
    }

    public DataFetcher<List<ProductDTO>> getProducts() {
        return productGraphqlFacadeService::getProducts;
    }

    public DataFetcher<Optional<ProductDTO>> getProductByUuid() {
        return productGraphqlFacadeService::getProductByUuid;
    }

    public DataFetcher<ProductDTO> createProduct() {
        return productGraphqlFacadeService::createProduct;
    }
}
