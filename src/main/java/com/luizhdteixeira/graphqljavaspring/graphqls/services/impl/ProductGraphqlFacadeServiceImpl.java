package com.luizhdteixeira.graphqljavaspring.graphqls.services.impl;

import com.luizhdteixeira.graphqljavaspring.domains.ProductEntity;
import com.luizhdteixeira.graphqljavaspring.domains.mappers.ProductMapper;
import com.luizhdteixeira.graphqljavaspring.domains.services.ProductService;
import com.luizhdteixeira.graphqljavaspring.graphqls.dto.ProductDTO;
import com.luizhdteixeira.graphqljavaspring.graphqls.services.ProductGraphqlFacadeService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        return mapper.productDTOSToProductEntities(productService.getProducts());
    }

    @Override
    public ProductDTO getProductByUuid(DataFetchingEnvironment dfe) {
        Optional<ProductEntity> productEntityOpt = productService.getProductByUuid(UUID.fromString(dfe.getArgument("uuid")));
        ProductEntity productEntity = productEntityOpt.orElse(null);
        return mapper.productDTOToProductEntity(productEntity);
    }

    @Override
    public ProductDTO createProduct(DataFetchingEnvironment dfe) {
        return mapper.productDTOToProductEntity(productService.createProduct(
                new ProductEntity(dfe.getArgument("name"),
                        BigDecimal.valueOf(Double.parseDouble(dfe.getArgument("value").toString())),
                        Double.valueOf(dfe.getArgument("quantity").toString()))
        ));
    }
}
