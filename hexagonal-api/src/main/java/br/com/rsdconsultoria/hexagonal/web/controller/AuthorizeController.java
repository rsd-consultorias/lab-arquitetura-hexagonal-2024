package br.com.rsdconsultoria.hexagonal.web.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rsdconsultoria.hexagonal.infrastructure.repository.InvoiceRepositoryImpl;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/authorize")
public class AuthorizeController {
    private InvoiceRepositoryImpl invoiceRepository;

    public AuthorizeController(final InvoiceRepositoryImpl invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @GetMapping("/")
    public Mono<Object> getInvoices() {
        return Mono.just(invoiceRepository.findById(UUID.randomUUID()))
                .map(invoice -> {
                    invoice.setDescription("processada");
                    return invoice;
                });
    }
}
