package br.com.rsdconsultoria.hexagonal.infrastructure.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.rsdconsultoria.hexagonal.domain.model.Invoice;
import br.com.rsdconsultoria.hexagonal.domain.model.Item;
import br.com.rsdconsultoria.hexagonal.domain.repository.InvoiceRepository;
import br.com.rsdconsultoria.hexagonal.infrastructure.adapter.out.jpa.InvoiceRepositoryJPA;

@Component
public class InvoiceRepositoryImpl implements InvoiceRepository {

    @Autowired
    private InvoiceRepositoryJPA invoiceRepositoryJPA;

    @Override
    public Invoice findById(UUID invoiceId) {
        Item item1 = new Item("Produto A", 2, new BigDecimal("50.00"));
        Item item2 = new Item("Produto B", 1, new BigDecimal("100.00"));
        Collection<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        Invoice invoice = new Invoice();
        invoice.setNumber("123456");
        invoice.setCustomerName("Empresa XYZ Ltda");
        invoice.setCustomerCNPJ("12.345.678/0001-99");
        invoice.setIssueDate(LocalDate.of(2024, 9, 12));
        invoice.setDueDate(LocalDate.of(2024, 10, 12));
        invoice.setTotalAmount(new BigDecimal("200.00"));
        invoice.setTaxAmount(new BigDecimal("36.00"));
        invoice.setDescription("Venda de produtos diversos");
        invoice.setPaymentMethod("Boleto Bancário");
        invoice.setItems(items);

        return invoice;
    }

    @Override
    public void save(Invoice invoice) {

    }

}
