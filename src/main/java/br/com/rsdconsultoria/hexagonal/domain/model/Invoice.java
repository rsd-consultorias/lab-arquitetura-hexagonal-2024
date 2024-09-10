package br.com.rsdconsultoria.hexagonal.domain.model;

import java.util.Collection;

public class Invoice {
    private Collection<Item> items;

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    public void markAsPaid() {

    }
}
