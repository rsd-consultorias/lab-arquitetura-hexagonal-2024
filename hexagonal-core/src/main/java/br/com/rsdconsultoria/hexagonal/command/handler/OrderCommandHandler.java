package br.com.rsdconsultoria.hexagonal.command.handler;

import br.com.rsdconsultoria.hexagonal.command.model.CancelOrderCommand;
import br.com.rsdconsultoria.hexagonal.command.model.Command;
import br.com.rsdconsultoria.hexagonal.command.model.CommandHandler;
import br.com.rsdconsultoria.hexagonal.command.model.CreateOrderCommand;
import br.com.rsdconsultoria.hexagonal.domain.constants.ExceptionMessages;
import br.com.rsdconsultoria.hexagonal.domain.repository.OrderRepository;

public class OrderCommandHandler implements CommandHandler {

    private final OrderRepository orderRepository;

    public OrderCommandHandler(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void handle(Command command) throws Exception {
        if (command instanceof CreateOrderCommand) {
            var createOrderCommand = (CreateOrderCommand) command;
            if (createOrderCommand.getCorrelationId().isEmpty()) {
                throw new Exception(ExceptionMessages.CORRELATION_ID_CANT_BE_EMPTY);
            }

            this.orderRepository.save(createOrderCommand.getNewOrder());
        } else if (command instanceof CancelOrderCommand) {
            var order = this.orderRepository.findOrderByLocator(((CreateOrderCommand) command).getNewOrder().getId());
        } else {
            // throw new Exception(ExceptionMessages.INVALID_COMMAND);
        }
    }

}
