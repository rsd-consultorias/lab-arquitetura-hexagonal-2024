package br.com.rsdconsultoria.hexagonal.command.model;

import java.math.BigDecimal;

// Command: Representa uma operação de escrita
public class CreateInvoiceCommand implements Command {
    private final String invoiceId;
    private final String customerId;
    private final BigDecimal amount;

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

