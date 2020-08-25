package com.luizhdteixeira.graphqljavaspring.domains.mappers;

import com.luizhdteixeira.graphqljavaspring.domains.ProductEntity;
import com.luizhdteixeira.graphqljavaspring.graphqls.dto.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    List<ProductDTO> productDTOSToProductEntities(List<ProductEntity> productEntities);

    ProductDTO productDTOToProductEntity(ProductEntity productEntity);

}
