package com.luizhdteixeira.graphqljavaspring.domains.repositories;

import com.luizhdteixeira.graphqljavaspring.domains.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
}
