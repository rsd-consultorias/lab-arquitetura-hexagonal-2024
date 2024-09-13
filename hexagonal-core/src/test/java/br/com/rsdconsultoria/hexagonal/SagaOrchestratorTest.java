package br.com.rsdconsultoria.hexagonal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

import br.com.rsdconsultoria.hexagonal.application.service.InventoryService;
import br.com.rsdconsultoria.hexagonal.application.service.OrderService;
import br.com.rsdconsultoria.hexagonal.application.service.PaymentService;
import br.com.rsdconsultoria.hexagonal.application.service.SagaOrchestrationService;
import br.com.rsdconsultoria.hexagonal.domain.model.Order;
import br.com.rsdconsultoria.hexagonal.domain.repository.InvoiceRepository;

public class SagaOrchestratorTest {

    @Mock
    private OrderService orderService;

    @Mock
    private PaymentService paymentService;

    @Mock
    private InventoryService inventoryService;

    @InjectMocks
    private SagaOrchestrationService sagaOrchestrator;

    @Mock
    private InvoiceRepository invoiceRepository;

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

        sagaOrchestrator.executeSaga(order);

        verify(orderService, times(1)).createOrder(order);
        verify(paymentService, times(1)).processPayment(order);
        verify(inventoryService, times(1)).updateInventory(order);
    }

    @Test
    public void testExecuteSagaFailure() {
        Order order = new Order();
        order.setId("1");
        order.setProduct("Product A");
        order.setQuantity(10);

        doThrow(new RuntimeException()).when(paymentService).processPayment(order);

        sagaOrchestrator.executeSaga(order);

        verify(orderService, times(1)).createOrder(order);
        verify(paymentService, times(1)).processPayment(order);
        verify(inventoryService, never()).updateInventory(order);
        verify(orderService, times(1)).cancelOrder(order);
        verify(paymentService, times(1)).refundPayment(order);
    }
}
