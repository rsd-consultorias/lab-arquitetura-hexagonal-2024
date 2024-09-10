package br.com.rsdconsultoria.hexagonal.application;

import java.math.BigDecimal;

import br.com.rsdconsultoria.hexagonal.domain.model.Invoice;
import br.com.rsdconsultoria.hexagonal.domain.repository.InvoiceRepository;
import br.com.rsdconsultoria.hexagonal.domain.service.InvoiceService;

public class AccountingApplicationService {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceService invoiceService;

    public AccountingApplicationService(InvoiceRepository invoiceRepository, InvoiceService invoiceService) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceService = invoiceService;
    }

    public void processInvoicePayment(Long invoiceId, BigDecimal paymentAmount) throws Exception {
        Invoice invoice = invoiceRepository.findById(invoiceId);
        BigDecimal totalAmount = invoiceService.calculateTotalAmount(invoice);

        if (paymentAmount.compareTo(totalAmount) > 0) {
            invoice.markAsPaid();
            invoiceRepository.save(invoice);
        } else {
            throw new Exception("MSG_ACC_001");
        }
    }
}
