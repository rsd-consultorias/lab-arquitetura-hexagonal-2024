package br.com.rsdconsultoria.hexagonal.domain.repository;

import br.com.rsdconsultoria.hexagonal.domain.model.Order;

public interface OrderRepository {
    void save(Order order);
    Order findOrderByLocator(String orderLocator);
}
