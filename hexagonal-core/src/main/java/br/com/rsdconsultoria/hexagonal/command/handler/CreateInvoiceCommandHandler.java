package br.com.rsdconsultoria.hexagonal.command.handler;

import br.com.rsdconsultoria.hexagonal.command.CreateInvoiceCommand;
import br.com.rsdconsultoria.hexagonal.command.service.InvoiceService;

// Handler: Lida com a execução do comando
public class CreateInvoiceCommandHandler {
    private final InvoiceService invoiceService;

    public CreateInvoiceCommandHandler(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void handle(CreateInvoiceCommand command) {
        invoiceService.createInvoice(command.getInvoiceId(), command.getCustomerId(), command.getAmount());
    }
}

