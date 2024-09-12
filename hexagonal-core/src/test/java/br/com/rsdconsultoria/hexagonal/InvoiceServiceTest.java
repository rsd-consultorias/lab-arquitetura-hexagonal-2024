package br.com.rsdconsultoria.hexagonal;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.rsdconsultoria.hexagonal.command.service.InvoiceService;

public class InvoiceServiceTest {

    private InvoiceService invoiceService = new InvoiceService();

    @Test
    public void testCreateInvoice() {
        // Aqui você pode adicionar lógica para verificar se a fatura foi criada corretamente
        // Por exemplo, você pode usar um repositório mockado para verificar a persistência
        invoiceService.createInvoice("1", "customer1", new BigDecimal("100.0"));
        // Verifique a saída no console ou adicione lógica de verificação
    }
}

