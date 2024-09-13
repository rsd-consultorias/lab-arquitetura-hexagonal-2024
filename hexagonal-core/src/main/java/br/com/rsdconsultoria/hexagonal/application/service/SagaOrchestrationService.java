package br.com.rsdconsultoria.hexagonal.application.service;

import br.com.rsdconsultoria.hexagonal.domain.model.Order;

public class SagaOrchestrationService {
    private OrderService orderService;
    private PaymentService paymentService;
    private InventoryService inventoryService;

    public SagaOrchestrationService(final OrderService orderService,
            final PaymentService paymentService,
            final InventoryService inventoryService) {
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
