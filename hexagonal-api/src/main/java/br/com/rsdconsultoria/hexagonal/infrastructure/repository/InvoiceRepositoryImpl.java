package br.com.rsdconsultoria.hexagonal.infrastructure.repository;

import java.util.UUID;

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
    public Invoice findById(UUID invoiceId) {
                
        return null;
    }

    @Override
    public void save(Invoice invoice) {

    }

}
