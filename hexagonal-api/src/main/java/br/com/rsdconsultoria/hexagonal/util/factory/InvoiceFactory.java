package br.com.rsdconsultoria.hexagonal.util.factory;

import br.com.rsdconsultoria.hexagonal.domain.model.Invoice;
import br.com.rsdconsultoria.hexagonal.web.dto.InvoiceResponse;

public class InvoiceFactory {
    public static InvoiceResponse builInvoiceResponseFromModel(Invoice model) {
        return new InvoiceResponse(model.getNumber(), model.getCustomerName(), model.getCustomerCNPJ(),
                model.getIssueDate(), model.getDueDate(), model.getTotalAmount(), model.getTaxAmount(),
                model.getDescription(), model.getPaymentMethod());
    }
}
