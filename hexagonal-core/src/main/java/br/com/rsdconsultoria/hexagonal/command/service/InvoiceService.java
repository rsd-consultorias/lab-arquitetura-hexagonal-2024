package br.com.rsdconsultoria.hexagonal.command.service;

import java.math.BigDecimal;

// Service: Serviço relacionado ao processamento de comandos
public class InvoiceService {

    public void createInvoice(String invoiceId, String customerId, BigDecimal amount) {
        // Lógica para criar uma fatura
        System.out.println("Invoice created: " + invoiceId + ", Customer: " + customerId + ", Amount: " + amount);
    }
}
