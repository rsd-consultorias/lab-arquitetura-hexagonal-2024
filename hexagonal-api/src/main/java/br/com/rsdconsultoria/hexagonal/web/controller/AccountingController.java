package br.com.rsdconsultoria.hexagonal.web.controller;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rsdconsultoria.hexagonal.application.service.AccountingApplicationService;
import br.com.rsdconsultoria.hexagonal.infrastructure.repository.InvoiceRepositoryImpl;
import br.com.rsdconsultoria.hexagonal.util.factory.InvoiceFactory;
import br.com.rsdconsultoria.hexagonal.web.dto.InvoiceResponse;

@RestController
@RequestMapping("/accounting")
public class AccountingController extends BaseController {
    private AccountingApplicationService accountingApplicationService;
    private InvoiceRepositoryImpl invoiceRepository;

    public AccountingController(final InvoiceRepositoryImpl invoiceRepository) {
        this.accountingApplicationService = new AccountingApplicationService(invoiceRepository);
        this.invoiceRepository = invoiceRepository;
    }

    @GetMapping("/invoice/{id}")
    public ResponseEntity<InvoiceResponse> getInvoiceById(@PathVariable("id") String id) {
        var invoice = invoiceRepository.findById(UUID.randomUUID());
        
        return ResponseEntity.ok(InvoiceFactory.builInvoiceResponseFromModel(invoice));
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> dummyTest(@PathVariable String name,
            @RequestHeader("x-country-code") String countryCode) {
        name = getMessage("NOT_FOUND", countryCode);
        int a = 1;
        int b = 1;

        logger.info("Teste de log a={}, b={}", a, b);
        logger.warn("Teste de log a={}, b={}", a, b);
        logger.debug("Teste de log a={}, b={}", a, b);

        try {
            this.accountingApplicationService.processInvoicePayment(UUID.randomUUID(), BigDecimal.ZERO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(getMessage(e.getMessage(), countryCode));
        }

        if (a == b) {
            return ResponseEntity.ok().body(getMessage("FOUND", countryCode));
        } else {
            return ResponseEntity.badRequest().body(getMessage("NOT_FOUND", countryCode));
        }
    }
}
