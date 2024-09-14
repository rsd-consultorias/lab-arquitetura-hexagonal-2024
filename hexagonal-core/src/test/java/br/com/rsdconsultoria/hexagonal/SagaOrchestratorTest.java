package br.com.rsdconsultoria.hexagonal;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import br.com.rsdconsultoria.hexagonal.application.service.PurchaseOrchestrationService;
import br.com.rsdconsultoria.hexagonal.command.handler.OrderCommandHandler;
import br.com.rsdconsultoria.hexagonal.command.model.CreateOrderCommand;
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

    @InjectMocks
    private PurchaseOrchestrationService sagaOrchestrator;

    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private OrderRepository orderRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testExecuteSagaSuccess() {
        Order order = new Order();
        Order order1 = new Order();
        order.setId("1");
        order.setProduct("Product A");
        order.setQuantity(10);
        var createOrderCommand = new CreateOrderCommand("1", order);

        try {
            sagaOrchestrator.execute(createOrderCommand, createOrderCommand, createOrderCommand);
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
        var createOrderCommand = new CreateOrderCommand("1", order);

        doThrow(new RuntimeException()).when(orderRepository).save(order);
        when(orderRepository.findOrderByLocator("1")).thenReturn(order);

        try {
            sagaOrchestrator.execute(createOrderCommand, createOrderCommand, createOrderCommand);
        } catch (Exception e) {
            assertEquals(e.getMessage(), ExceptionMessages.ROLLBACK_TRANSACTION);
        }
    }
}
