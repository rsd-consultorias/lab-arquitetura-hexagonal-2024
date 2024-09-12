package br.com.rsdconsultoria.hexagonal.query.service;

import br.com.rsdconsultoria.hexagonal.query.model.InvoiceQueryModel;

// Service: Serviço relacionado ao processamento de consultas
public class InvoiceQueryService {
    public InvoiceQueryModel getInvoice(String invoiceId) {
        // Lógica para recuperar uma fatura
        return new InvoiceQueryModel(invoiceId, "Example Customer", 100.0);
    }
}
