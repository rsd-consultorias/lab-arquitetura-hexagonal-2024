package br.com.rsdconsultoria.hexagonal.infrastructure.adapter.out.jpa;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ItemEntity {
    @Id
    private UUID id;
    private BigDecimal price;
    private BigInteger quantity;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }
}
