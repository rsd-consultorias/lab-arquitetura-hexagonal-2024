package br.com.rsdconsultoria.hexagonal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.rsdconsultoria.hexagonal.application.service.PaymentService;
import br.com.rsdconsultoria.hexagonal.domain.model.Order;
import br.com.rsdconsultoria.hexagonal.domain.repository.OrderRepository;

public class PaymentServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private PaymentService paymentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

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
