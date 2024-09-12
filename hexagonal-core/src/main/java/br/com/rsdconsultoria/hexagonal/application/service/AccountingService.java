package br.com.rsdconsultoria.hexagonal.application.service;

import java.math.BigDecimal;
import java.util.UUID;

import br.com.rsdconsultoria.hexagonal.domain.constants.ExceptionMessages;
import br.com.rsdconsultoria.hexagonal.domain.model.Invoice;
import br.com.rsdconsultoria.hexagonal.domain.repository.InvoiceRepository;
import br.com.rsdconsultoria.hexagonal.domain.service.InvoiceService;

public class AccountingService {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceService invoiceService;

    public AccountingService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceService = new InvoiceService();
    }

    public void processInvoicePayment(UUID invoiceId, BigDecimal paymentAmount) throws Exception {
        Invoice invoice = invoiceRepository.findById(invoiceId);
        BigDecimal totalAmount = invoiceService.calculateTotalAmount(invoice);

        if (paymentAmount.compareTo(totalAmount) > 0) {
            invoice.markAsPaid();
            invoiceRepository.save(invoice);
        } else {
            throw new Exception(ExceptionMessages.MSG_ACC_001);
        }
    }
}
