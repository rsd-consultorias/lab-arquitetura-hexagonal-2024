package br.com.rsdconsultoria.hexagonal.infrastructure.repository;

import br.com.rsdconsultoria.hexagonal.domain.model.Order;
import br.com.rsdconsultoria.hexagonal.domain.repository.OrderRepository;

public class OrderRepositoryImpl implements OrderRepository {

    @Override
    public void save(Order order) {
    }

    @Override
    public Order findOrderByLocator(String orderLocator) {
        var order = new Order();
        order.setId("1");
        order.setProduct("Product");
        order.setQuantity(1);
        order.setId("1");

        return order;
    }
    
}
