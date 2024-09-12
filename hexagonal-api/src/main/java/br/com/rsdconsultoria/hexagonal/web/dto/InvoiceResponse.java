package br.com.rsdconsultoria.hexagonal.web.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record InvoiceResponse(
        String number,
        String customerName,
        String customerCNPJ,
        LocalDate issueDate,
        LocalDate dueDate,
        BigDecimal totalAmount,
        BigDecimal taxAmount,
        String description,
        String paymentMethod) {
}
