package br.com.rsdconsultoria.hexagonal.domain.service;

import java.math.BigDecimal;

import br.com.rsdconsultoria.hexagonal.domain.model.Invoice;

public class InvoiceService {
    public BigDecimal calculateTotalAmount(Invoice invoice) {
        
        return BigDecimal.ZERO;
    }
}
