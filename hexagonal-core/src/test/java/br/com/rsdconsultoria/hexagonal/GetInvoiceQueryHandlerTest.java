package br.com.rsdconsultoria.hexagonal;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.rsdconsultoria.hexagonal.query.GetInvoiceQuery;
import br.com.rsdconsultoria.hexagonal.query.handler.GetInvoiceQueryHandler;
import br.com.rsdconsultoria.hexagonal.query.model.InvoiceQueryModel;
import br.com.rsdconsultoria.hexagonal.query.service.InvoiceQueryService;

public class GetInvoiceQueryHandlerTest {

    @Mock
    private InvoiceQueryService invoiceQueryService;

    @InjectMocks
    private GetInvoiceQueryHandler getInvoiceQueryHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testHandle() {
        GetInvoiceQuery query = new GetInvoiceQuery("1");
        InvoiceQueryModel expectedInvoice = new InvoiceQueryModel("1", "customer1", 100.0);

        when(invoiceQueryService.getInvoice("1")).thenReturn(expectedInvoice);

        InvoiceQueryModel result = getInvoiceQueryHandler.handle(query);

        assertEquals(expectedInvoice, result);
        verify(invoiceQueryService, times(1)).getInvoice("1");
    }
}

