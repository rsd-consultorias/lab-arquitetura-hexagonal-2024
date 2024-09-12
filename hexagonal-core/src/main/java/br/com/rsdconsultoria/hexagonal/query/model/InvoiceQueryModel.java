package br.com.rsdconsultoria.hexagonal.query.model;

// Model: Modelo específico para consultas
public class InvoiceQueryModel {
    private String invoiceId;
    private String customerId;
    private double amount;

    public InvoiceQueryModel(String invoiceId, String customerId, double amount) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.amount = amount;
    }

    // Getters and setters
    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
