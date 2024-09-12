package br.com.rsdconsultoria.hexagonal.tests;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.rsdconsultoria.hexagonal.application.service.InventoryService;
import br.com.rsdconsultoria.hexagonal.application.service.OrderService;
import br.com.rsdconsultoria.hexagonal.application.service.PaymentService;
import br.com.rsdconsultoria.hexagonal.domain.model.Order;
import br.com.rsdconsultoria.hexagonal.integration.SagaOrchestrator;

@RunWith(MockitoJUnitRunner.class)
public class SagaOrchestratorTest {

    private SagaOrchestrator sagaOrchestrator;

    private OrderService orderService = new OrderService();

    private PaymentService paymentService = new PaymentService();

    private InventoryService inventoryService = new InventoryService();

    @Test
    public void testExecuteSagaSuccess() {
        sagaOrchestrator = new SagaOrchestrator(orderService, paymentService, inventoryService);
        Order order = new Order();
        order.setId("1");
        order.setProduct("Product A");
        order.setQuantity(10);

        sagaOrchestrator.executeSaga(order);

        // verify(orderService).createOrder(order);
        // verify(paymentService).processPayment(order);
        // verify(inventoryService).updateInventory(order);
    }

    @Test
    public void testExecuteSagaFailure() {
        sagaOrchestrator = new SagaOrchestrator(orderService, paymentService, inventoryService);
        Order order = new Order();
        order.setId("1");
        order.setProduct("Product A");
        order.setQuantity(10);

        // doThrow(new RuntimeException()).when(paymentService).processPayment(order);

        sagaOrchestrator.executeSaga(order);

        // verify(orderService).createOrder(order);
        // verify(paymentService).processPayment(order);
        // verify(inventoryService, never()).updateInventory(order);
        // verify(orderService).cancelOrder(order);
        // verify(paymentService).refundPayment(order);
    }
}
