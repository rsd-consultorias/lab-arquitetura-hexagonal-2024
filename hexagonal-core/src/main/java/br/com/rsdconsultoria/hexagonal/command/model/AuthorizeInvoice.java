package br.com.rsdconsultoria.hexagonal.command.model;

import br.com.rsdconsultoria.hexagonal.domain.model.Invoice;

public class AuthorizeInvoice {
    private Invoice invoice;
    private String status;

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
