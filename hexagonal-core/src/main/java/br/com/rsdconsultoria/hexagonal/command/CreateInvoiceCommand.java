package br.com.rsdconsultoria.hexagonal.command;

import java.math.BigDecimal;

// Command: Representa uma operação de escrita
public class CreateInvoiceCommand {
    private String invoiceId;
    private String customerId;
    private BigDecimal amount;

    public CreateInvoiceCommand(String invoiceId, String customerId, BigDecimal amount) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.amount = amount;
    }

    // Getters
    public String getInvoiceId() {
        return invoiceId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

