package br.com.rsdconsultoria.hexagonal;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import br.com.rsdconsultoria.hexagonal.command.service.OrderService;
import br.com.rsdconsultoria.hexagonal.domain.model.Order;

public class OrderServiceTest {

    private OrderService orderService = new OrderService();

    @Test
    public void testCreateOrder() {
        Order order = new Order();
        order.setId("1");
        order.setProduct("Product A");
        order.setQuantity(10);

        orderService.createOrder(order);

        // Adicione asserções conforme necessário
        // Exemplo: assertEquals("1", order.getId());
    }

    @Test
    public void testCancelOrder() {
        Order order = new Order();
        order.setId("1");
        order.setProduct("Product A");
        order.setQuantity(10);

        orderService.cancelOrder(order);

        // Adicione asserções conforme necessário
        // Exemplo: assertEquals("1", order.getId());
    }
}

