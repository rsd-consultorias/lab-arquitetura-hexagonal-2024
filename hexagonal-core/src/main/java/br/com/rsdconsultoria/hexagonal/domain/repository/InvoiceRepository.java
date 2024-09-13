package br.com.rsdconsultoria.hexagonal.domain.repository;

import java.util.UUID;

import br.com.rsdconsultoria.hexagonal.domain.model.Invoice;

public interface InvoiceRepository {

    Invoice findById(UUID invoiceId);
    void save(Invoice invoice);
}
