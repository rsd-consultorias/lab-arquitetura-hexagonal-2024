package br.com.rsdconsultoria.hexagonal.application.service;

import br.com.rsdconsultoria.hexagonal.command.handler.OrderCommandHandler;
import br.com.rsdconsultoria.hexagonal.command.model.CreateOrderCommand;
import br.com.rsdconsultoria.hexagonal.domain.constants.ExceptionMessages;

public class PurchaseOrchestrationService {

    private final OrderCommandHandler orderCommandHandler;
    private final OrderCommandHandler paymentCommandHandler;
    private final OrderCommandHandler inventoryCommandHandler;

    public PurchaseOrchestrationService(
            final OrderCommandHandler orderCommandHandler,
            final OrderCommandHandler paymentCommandHandler,
            final OrderCommandHandler inventoryCommandHandler) {
        this.orderCommandHandler = orderCommandHandler;
        this.paymentCommandHandler = paymentCommandHandler;
        this.inventoryCommandHandler = inventoryCommandHandler;
    }

    public void execute(
            CreateOrderCommand createOrderCommand,
            CreateOrderCommand createPaymentCommand,
            CreateOrderCommand updateInventoryCommand) throws Exception {
        try {
            // Cria pedido
            orderCommandHandler.handle(createOrderCommand);

            // Se criar com suceso confirma captura do pagamento
            paymentCommandHandler.handle(createPaymentCommand);

            // Se pagamento realizado com sucesso atualiza estoque
            inventoryCommandHandler.handle(updateInventoryCommand);
        } catch (Exception e) {
            // Lógica de compensação

            // Reverte o pedido
            orderCommandHandler.handle(createOrderCommand);

            // Estorna o pagamente
            paymentCommandHandler.handle(createPaymentCommand);

            // Devolve estoque
            inventoryCommandHandler.handle(updateInventoryCommand);

            throw new Exception(ExceptionMessages.ROLLBACK_TRANSACTION);
        }
    }
}
