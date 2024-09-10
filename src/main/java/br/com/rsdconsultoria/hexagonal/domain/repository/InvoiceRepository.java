package br.com.rsdconsultoria.hexagonal.domain.repository;

import br.com.rsdconsultoria.hexagonal.domain.model.Invoice;

public interface InvoiceRepository {

    Invoice findById(Long invoiceId);

    void save(Invoice invoice);

}
