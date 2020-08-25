package com.luizhdteixeira.graphqljavaspring.domains;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class ProductEntity implements Serializable {

    private static final long serialVersionUID = 1399274800485312349L;

    @Id
    @GeneratedValue
    private UUID uuid;
    private String name;
    private BigDecimal value;
    private Double quantity;
    @CreationTimestamp
    private LocalDate createdDate;
    @UpdateTimestamp
    private LocalDate updatedDate;

    // Default
    public ProductEntity() {
    }

    // Create Product
    public ProductEntity(String name, BigDecimal value, Double quantity) {
        this.name = name;
        this.value = value;
        this.quantity = quantity;
    }

    // Update Product
    public ProductEntity(String name, BigDecimal value, Double quantity, LocalDate createdDate) {
        this.name = name;
        this.value = value;
        this.quantity = quantity;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }
}
