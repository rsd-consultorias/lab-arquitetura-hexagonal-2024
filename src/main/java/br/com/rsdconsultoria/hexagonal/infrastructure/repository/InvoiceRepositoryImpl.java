package br.com.rsdconsultoria.hexagonal.infrastructure.repository;

import org.springframework.stereotype.Component;

import br.com.rsdconsultoria.hexagonal.domain.model.Invoice;
import br.com.rsdconsultoria.hexagonal.domain.repository.InvoiceRepository;

@Component
public class InvoiceRepositoryImpl implements InvoiceRepository {

    @Override
    public Invoice findById(Long invoiceId) {
        return new Invoice();
    }

    @Override
    public void save(Invoice invoice) {

    }

}
