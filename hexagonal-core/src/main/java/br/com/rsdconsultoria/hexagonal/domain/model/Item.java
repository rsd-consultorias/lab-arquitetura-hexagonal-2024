package br.com.rsdconsultoria.hexagonal.domain.model;

import java.math.BigDecimal;

public class Item {
    private String name;
    private int quantity;
    private BigDecimal price;

    public Item(String name, int quantity, BigDecimal price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
