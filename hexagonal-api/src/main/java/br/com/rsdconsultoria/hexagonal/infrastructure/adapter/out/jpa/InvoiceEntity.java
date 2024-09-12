package br.com.rsdconsultoria.hexagonal.infrastructure.adapter.out.jpa;

import java.util.Collection;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class InvoiceEntity {
    @Id
    private UUID id;
    @OneToMany
    private Collection<ItemEntity> items;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Collection<ItemEntity> getItems() {
        return items;
    }

    public void setItems(Collection<ItemEntity> items) {
        this.items = items;
    }

}
