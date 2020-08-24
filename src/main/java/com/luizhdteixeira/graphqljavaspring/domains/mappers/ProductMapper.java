package com.luizhdteixeira.graphqljavaspring.domains.mappers;

import com.luizhdteixeira.graphqljavaspring.domains.ProductEntity;
import com.luizhdteixeira.graphqljavaspring.graphqls.dto.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    List<ProductDTO> productDTOSToProductEntities(List<ProductEntity> productEntities);

    List<ProductEntity> productEntitiesToProductDTOS(List<ProductDTO> productDTOS);

    Optional<ProductDTO> productDTOOptToProductEntityOpt(ProductEntity productEntityOpt);

    Optional<ProductEntity> productEntityOptToProductDTOOpt(ProductDTO productDTOOpt);

    ProductDTO productDTOToProductEntity(ProductEntity productEntity);

    ProductEntity productEntityToProductDTO(ProductDTO productDTO);

}
