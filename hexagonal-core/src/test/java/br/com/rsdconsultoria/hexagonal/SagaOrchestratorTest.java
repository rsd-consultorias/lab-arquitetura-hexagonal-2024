package br.com.rsdconsultoria.hexagonal;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import br.com.rsdconsultoria.hexagonal.application.service.PurchaseOrchestrationService;
import br.com.rsdconsultoria.hexagonal.command.handler.InventoryCommandHandler;
import br.com.rsdconsultoria.hexagonal.command.handler.OrderCommandHandler;
import br.com.rsdconsultoria.hexagonal.command.handler.PaymentCommandhandler;
import br.com.rsdconsultoria.hexagonal.command.model.CreateOrderCommand;
import br.com.rsdconsultoria.hexagonal.command.model.CreatePaymentCommand;
import br.com.rsdconsultoria.hexagonal.command.model.UpdateInventoryCommand;
import br.com.rsdconsultoria.hexagonal.command.service.InventoryService;
import br.com.rsdconsultoria.hexagonal.command.service.OrderService;
import br.com.rsdconsultoria.hexagonal.command.service.PaymentService;
import br.com.rsdconsultoria.hexagonal.domain.constants.ExceptionMessages;
import br.com.rsdconsultoria.hexagonal.domain.model.Order;
import br.com.rsdconsultoria.hexagonal.domain.repository.InvoiceRepository;
import br.com.rsdconsultoria.hexagonal.domain.repository.OrderRepository;

public class SagaOrchestratorTest {

    @Mock
    private OrderService orderService;

    @Mock
    private PaymentService paymentService;

    @Mock
    private InventoryService inventoryService;

    @Mock
    private OrderCommandHandler orderCommandHandler;
    
    @Mock
    private InventoryCommandHandler inventoryCommandHandler;
    
    @Mock
    private PaymentCommandhandler paymentCommandhandler;

    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private PurchaseOrchestrationService sagaOrchestrator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testExecuteSagaSuccess() {
        Order order = new Order();
        order.setId("1");
        order.setProduct("Product A");
        order.setQuantity(10);
        var createOrderCommand = new CreateOrderCommand("1", order);
        var createPaymentCommand = new CreatePaymentCommand();
        var updateInventoryCommand = new UpdateInventoryCommand();

        try {
            sagaOrchestrator.execute(createOrderCommand, createPaymentCommand, updateInventoryCommand);
        } catch (Exception e) {
            assertEquals(e, null);
        }
    }

    @Test
    public void testExecuteSagaFailure() {
        Order order = new Order();
        order.setId("1");
        order.setProduct("Product A");
        order.setQuantity(10);
        var createOrderCommand = new CreateOrderCommand("", order);

        when(orderRepository.findOrderByLocator("1")).thenReturn(order);
        var createPaymentCommand = new CreatePaymentCommand();
        var updateInventoryCommand = new UpdateInventoryCommand();

        try {
            sagaOrchestrator.execute(createOrderCommand, createPaymentCommand, updateInventoryCommand);
        } catch (Exception e) {
            assertEquals(e.getMessage(), ExceptionMessages.CORRELATION_ID_CANT_BE_EMPTY);
        }
    }
}
