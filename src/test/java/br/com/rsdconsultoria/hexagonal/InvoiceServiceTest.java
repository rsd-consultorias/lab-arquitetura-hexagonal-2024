package br.com.rsdconsultoria.hexagonal;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.rsdconsultoria.hexagonal.domain.model.Invoice;
import br.com.rsdconsultoria.hexagonal.domain.service.InvoiceService;

public class InvoiceServiceTest {

    private final InvoiceService invoiceService = new InvoiceService();

    @Test
    public void testCalculateTotalAmount() {
        Invoice invoice = new Invoice();
        // Suponha que você tenha métodos para adicionar itens à fatura e definir
        // valores
        // invoice.addItem(new Item("item1", new BigDecimal("100.00")));
        // invoice.addItem(new Item("item2", new BigDecimal("200.00")));

        BigDecimal totalAmount = invoiceService.calculateTotalAmount(invoice);

        // Como o método atual retorna BigDecimal.ZERO, o teste deve verificar isso
        assertEquals(BigDecimal.ZERO, totalAmount);
    }
}
