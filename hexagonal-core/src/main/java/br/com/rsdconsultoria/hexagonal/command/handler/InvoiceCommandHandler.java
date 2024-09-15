package br.com.rsdconsultoria.hexagonal.command.handler;

import br.com.rsdconsultoria.hexagonal.command.model.CreateInvoiceCommand;
import br.com.rsdconsultoria.hexagonal.command.service.InvoiceService;

// Handler: Lida com a execução do comando
public class InvoiceCommandHandler {
    private final InvoiceService invoiceService;

    public InvoiceCommandHandler() {
        this.invoiceService = new InvoiceService();
    }

    public void handle(CreateInvoiceCommand command) {
        invoiceService.createInvoice(command.getInvoiceId(), command.getCustomerId(), command.getAmount());
    }
}
