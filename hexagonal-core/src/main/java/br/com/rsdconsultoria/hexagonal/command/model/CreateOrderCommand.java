package br.com.rsdconsultoria.hexagonal.command.model;

import br.com.rsdconsultoria.hexagonal.domain.model.Order;

public class CreateOrderCommand implements Command<Order> {

    private final String correlationId;
    private final Order newOrder;

    public CreateOrderCommand(String correlationId, Order newOrder) {
        this.correlationId = correlationId;
        this.newOrder = newOrder;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public Order getNewOrder() {
        return newOrder;
    }
}
