package br.com.rsdconsultoria.hexagonal;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import br.com.rsdconsultoria.hexagonal.query.model.InvoiceQueryModel;
import br.com.rsdconsultoria.hexagonal.query.service.InvoiceQueryService;

public class InvoiceQueryServiceTest {

    private InvoiceQueryService invoiceQueryService = new InvoiceQueryService();

    @Test
    public void testGetInvoice() {
        InvoiceQueryModel result = invoiceQueryService.getInvoice("1");

        assertNotNull(result);
        assertEquals("1", result.getInvoiceId());
        assertEquals("Example Customer", result.getCustomerId());
        assertEquals(100.0, result.getAmount());
    }
}

