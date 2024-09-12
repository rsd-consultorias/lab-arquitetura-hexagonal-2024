package br.com.rsdconsultoria.hexagonal;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.rsdconsultoria.hexagonal.application.service.AccountingApplicationService;
import br.com.rsdconsultoria.hexagonal.command.service.InvoiceService;
import br.com.rsdconsultoria.hexagonal.domain.model.Invoice;
import br.com.rsdconsultoria.hexagonal.domain.repository.InvoiceRepository;

public class AccountingApplicationServiceTest {

    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private InvoiceService invoiceService;

    @InjectMocks
    private AccountingApplicationService accountingApplicationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProcessInvoicePayment_Success() throws Exception {
        UUID invoiceId = UUID.randomUUID();
        BigDecimal paymentAmount = new BigDecimal("1000.00");

        Invoice invoice = mock(Invoice.class);
        when(invoiceRepository.findById(invoiceId)).thenReturn(invoice);

        accountingApplicationService.processInvoicePayment(invoiceId, paymentAmount);

        verify(invoice).markAsPaid();
        verify(invoiceRepository).save(invoice);
    }

    @Test
    public void testProcessInvoicePayment_Failure() {
        UUID invoiceId = UUID.randomUUID();
        BigDecimal paymentAmount = new BigDecimal("0");

        Invoice invoice = mock(Invoice.class);
        when(invoiceRepository.findById(invoiceId)).thenReturn(invoice);

        Exception exception = assertThrows(Exception.class, () -> {
            accountingApplicationService.processInvoicePayment(invoiceId, paymentAmount);
        });

        assertEquals("MSG_ACC_001", exception.getMessage());
        verify(invoice, never()).markAsPaid();
        verify(invoiceRepository, never()).save(invoice);
    }
}
