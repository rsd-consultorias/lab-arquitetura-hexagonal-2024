package br.com.rsdconsultoria.hexagonal.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.rsdconsultoria.hexagonal.domain.model.Invoice;
import br.com.rsdconsultoria.hexagonal.domain.repository.InvoiceRepository;
import br.com.rsdconsultoria.hexagonal.infrastructure.adapter.out.jpa.InvoiceRepositoryJPA;

@Component
public class InvoiceRepositoryImpl implements InvoiceRepository {

    @Autowired
    private InvoiceRepositoryJPA invoiceRepositoryJPA;

    @Override
    public Invoice findById(Long invoiceId) {
                
        return new Invoice();
    }

    @Override
    public void save(Invoice invoice) {

    }

}
