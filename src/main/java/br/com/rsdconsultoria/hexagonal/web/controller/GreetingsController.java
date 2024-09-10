package br.com.rsdconsultoria.hexagonal.web.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rsdconsultoria.hexagonal.application.AccountingApplicationService;
import br.com.rsdconsultoria.hexagonal.domain.repository.InvoiceRepository;
import br.com.rsdconsultoria.hexagonal.domain.service.InvoiceService;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController extends BaseController {
    private AccountingApplicationService accountingApplicationService;

    public GreetingsController(final InvoiceRepository invoiceRepository) {
        this.accountingApplicationService = new AccountingApplicationService(invoiceRepository, new InvoiceService());
    }

    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> greetingText(@PathVariable String name,
            @RequestHeader("x-country-code") String countryCode) {
        name = getMessage("NOT_FOUND", countryCode);
        int a = 1;
        int b = 1;

        logger.info("Teste de log a={}, b={}", a, b);
        logger.warn("Teste de log a={}, b={}", a, b);
        logger.debug("Teste de log a={}, b={}", a, b);

        try {
            this.accountingApplicationService.processInvoicePayment(0l, BigDecimal.ZERO);
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
