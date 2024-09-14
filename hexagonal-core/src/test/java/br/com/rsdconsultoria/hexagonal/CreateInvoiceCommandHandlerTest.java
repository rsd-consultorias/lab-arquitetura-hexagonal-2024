package br.com.rsdconsultoria.hexagonal;

import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.rsdconsultoria.hexagonal.command.model.CreateInvoiceCommand;
import br.com.rsdconsultoria.hexagonal.command.handler.CreateInvoiceCommandHandler;
import br.com.rsdconsultoria.hexagonal.command.service.InvoiceService;

public class CreateInvoiceCommandHandlerTest {

    @Mock
    private InvoiceService invoiceService;

    @InjectMocks
    private CreateInvoiceCommandHandler createInvoiceCommandHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testHandle() {
        CreateInvoiceCommand command = new CreateInvoiceCommand("1", "customer1", new BigDecimal("100.0"));

        createInvoiceCommandHandler.handle(command);

        // verify(invoiceService, times(1)).createInvoice("1", "customer1", new BigDecimal("100.0"));
    }
}
