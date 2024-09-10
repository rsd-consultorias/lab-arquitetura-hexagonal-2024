package br.com.rsdconsultoria.hexagonal.domain.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Item {
    private BigDecimal price;
    private BigInteger quantity;

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
