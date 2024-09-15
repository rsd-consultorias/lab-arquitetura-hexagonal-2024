package br.com.rsdconsultoria.hexagonal.application.service;

import br.com.rsdconsultoria.hexagonal.command.handler.InventoryCommandHandler;
import br.com.rsdconsultoria.hexagonal.command.handler.OrderCommandHandler;
import br.com.rsdconsultoria.hexagonal.command.handler.PaymentCommandhandler;
import br.com.rsdconsultoria.hexagonal.command.model.CreateOrderCommand;
import br.com.rsdconsultoria.hexagonal.command.model.CreatePaymentCommand;
import br.com.rsdconsultoria.hexagonal.command.model.UpdateInventoryCommand;
import br.com.rsdconsultoria.hexagonal.domain.constants.ExceptionMessages;

/**
 * Exemplo 11: Implementação de SAGA Pattern
 *
 * Resumo: Gerencia consistência de dados em microsserviços com transações
 * locais sequenciais e compensatórias para falhas.
 */
public class PurchaseOrchestrationService {

    private final OrderCommandHandler orderCommandHandler;
    private final PaymentCommandhandler paymentCommandHandler;
    private final InventoryCommandHandler inventoryCommandHandler;

    public PurchaseOrchestrationService(
            final OrderCommandHandler orderCommandHandler,
            final PaymentCommandhandler paymentCommandHandler,
            final InventoryCommandHandler inventoryCommandHandler) {
        this.orderCommandHandler = orderCommandHandler;
        this.paymentCommandHandler = paymentCommandHandler;
        this.inventoryCommandHandler = inventoryCommandHandler;
    }

    public void execute(
            CreateOrderCommand createOrderCommand,
            CreatePaymentCommand createPaymentCommand,
            UpdateInventoryCommand updateInventoryCommand) throws Exception {
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
