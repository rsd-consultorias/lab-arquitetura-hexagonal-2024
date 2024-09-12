package br.com.rsdconsultoria.hexagonal.integration;

import br.com.rsdconsultoria.hexagonal.application.service.InventoryService;
import br.com.rsdconsultoria.hexagonal.application.service.OrderService;
import br.com.rsdconsultoria.hexagonal.application.service.PaymentService;
import br.com.rsdconsultoria.hexagonal.domain.model.Order;

public class SagaOrchestrator {

    private OrderService orderService;

    private PaymentService paymentService;

    private InventoryService inventoryService;

    public SagaOrchestrator(OrderService orderService,
            PaymentService paymentService,
            InventoryService inventoryService) {
        this.orderService = orderService;
        this.paymentService = paymentService;
        this.inventoryService = inventoryService;
    }

    public void executeSaga(Order order) {
        try {
            orderService.createOrder(order);
            paymentService.processPayment(order);
            inventoryService.updateInventory(order);
        } catch (Exception e) {
            // Lógica de compensação
            orderService.cancelOrder(order);
            paymentService.refundPayment(order);
            inventoryService.revertInventory(order);
        }
    }
}
