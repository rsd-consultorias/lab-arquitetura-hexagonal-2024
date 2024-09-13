package br.com.rsdconsultoria.hexagonal.application.service;

import br.com.rsdconsultoria.hexagonal.domain.model.Order;
import br.com.rsdconsultoria.hexagonal.domain.repository.OrderRepository;

public class PaymentService {
    private final OrderRepository orderRepository;

    public PaymentService(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void processPayment(Order order) {
        // Lógica para processar pagamento
        orderRepository.save(order);
    }

    public void refundPayment(Order order) {
    }
}
