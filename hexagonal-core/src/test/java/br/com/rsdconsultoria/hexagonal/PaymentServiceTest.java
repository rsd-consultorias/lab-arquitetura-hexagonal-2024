package br.com.rsdconsultoria.hexagonal;

import org.junit.jupiter.api.Test;

import br.com.rsdconsultoria.hexagonal.application.service.PaymentService;
import br.com.rsdconsultoria.hexagonal.domain.model.Order;

public class PaymentServiceTest {

    private PaymentService paymentService = new PaymentService();

    @Test
    public void testProcessPayment() {
        Order order = new Order();
        order.setId("1");
        order.setProduct("Product A");
        order.setQuantity(10);

        paymentService.processPayment(order);

        // Adicione asserções conforme necessário
        // Exemplo: assertEquals("1", order.getId());
    }

    @Test
    public void testRefundPayment() {
        Order order = new Order();
        order.setId("1");
        order.setProduct("Product A");
        order.setQuantity(10);

        paymentService.refundPayment(order);

        // Adicione asserções conforme necessário
        // Exemplo: assertEquals("1", order.getId());
    }
}
