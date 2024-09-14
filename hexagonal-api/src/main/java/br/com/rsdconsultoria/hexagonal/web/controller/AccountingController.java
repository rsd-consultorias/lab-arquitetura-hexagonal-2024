package br.com.rsdconsultoria.hexagonal.web.controller;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rsdconsultoria.hexagonal.application.service.AccountingService;
import br.com.rsdconsultoria.hexagonal.application.service.PurchaseOrchestrationService;
import br.com.rsdconsultoria.hexagonal.command.handler.CreateInvoiceCommandHandler;
import br.com.rsdconsultoria.hexagonal.command.handler.OrderCommandHandler;
import br.com.rsdconsultoria.hexagonal.command.model.CreateInvoiceCommand;
import br.com.rsdconsultoria.hexagonal.command.model.CreateOrderCommand;
import br.com.rsdconsultoria.hexagonal.domain.model.Order;
import br.com.rsdconsultoria.hexagonal.infrastructure.repository.InvoiceRepositoryImpl;
import br.com.rsdconsultoria.hexagonal.infrastructure.repository.OrderRepositoryImpl;
import br.com.rsdconsultoria.hexagonal.util.factory.InvoiceFactory;
import br.com.rsdconsultoria.hexagonal.web.dto.ApiErrorResponse;
import br.com.rsdconsultoria.hexagonal.web.dto.InvoiceResponse;

@RestController
@RequestMapping("/accounting")
public class AccountingController extends BaseController {
    private final AccountingService accountingApplicationService;
    private final InvoiceRepositoryImpl invoiceRepository;
    private final CreateInvoiceCommandHandler createInvoiceCommandHandler;
    private final PurchaseOrchestrationService sagaOrchestrator;
    private final OrderRepositoryImpl orderRepository;

    public AccountingController(final InvoiceRepositoryImpl invoiceRepository,
            final OrderRepositoryImpl orderRepository) {
        this.accountingApplicationService = new AccountingService(invoiceRepository);
        this.invoiceRepository = invoiceRepository;
        this.orderRepository = orderRepository;
        this.createInvoiceCommandHandler = new CreateInvoiceCommandHandler();

        // TODO: refatorar essa parte ;)
        var orderCommandHandler = new OrderCommandHandler(orderRepository);
        this.sagaOrchestrator = new PurchaseOrchestrationService(
                orderCommandHandler, orderCommandHandler, orderCommandHandler);
    }

    @PostMapping("/createInvoice")
    public ResponseEntity<Object> createInvoice(
            @RequestBody CreateInvoiceCommand command,
            @RequestHeader(value = "language", required = false, defaultValue = "") String language) {
        Order order = new Order();
        order.setId("1");
        order.setProduct("Product A");
        order.setQuantity(10);
        var createOrderCommand = new CreateOrderCommand("1", order);

        try {
            sagaOrchestrator.execute(createOrderCommand, createOrderCommand, createOrderCommand);
        } catch (Exception e) {
            var errorBody = new ApiErrorResponse(e.getMessage(), getMessage(e.getMessage(), language));

            return ResponseEntity.badRequest().body(errorBody);
        }

        createInvoiceCommandHandler.handle(command);
        return ResponseEntity.ok().build();
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
