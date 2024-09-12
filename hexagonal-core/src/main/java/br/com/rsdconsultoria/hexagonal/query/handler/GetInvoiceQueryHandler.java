package br.com.rsdconsultoria.hexagonal.query.handler;

import br.com.rsdconsultoria.hexagonal.query.GetInvoiceQuery;
import br.com.rsdconsultoria.hexagonal.query.model.InvoiceQueryModel;
import br.com.rsdconsultoria.hexagonal.query.service.InvoiceQueryService;

// Handler: Lida com a execução da consulta
public class GetInvoiceQueryHandler {
    private final InvoiceQueryService invoiceQueryService;

    public GetInvoiceQueryHandler(InvoiceQueryService invoiceQueryService) {
        this.invoiceQueryService = invoiceQueryService;
    }

    public InvoiceQueryModel handle(GetInvoiceQuery query) {
        return invoiceQueryService.getInvoice(query.getInvoiceId());
    }
}

