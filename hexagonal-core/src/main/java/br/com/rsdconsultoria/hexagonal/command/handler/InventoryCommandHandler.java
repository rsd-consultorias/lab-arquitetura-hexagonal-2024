package br.com.rsdconsultoria.hexagonal.command.handler;

import br.com.rsdconsultoria.hexagonal.command.model.Command;
import br.com.rsdconsultoria.hexagonal.command.model.CommandHandler;
import br.com.rsdconsultoria.hexagonal.command.model.UpdateInventoryCommand;

public class InventoryCommandHandler implements CommandHandler {

    @Override
    public void handle(Command command) throws Exception {
        if (command instanceof UpdateInventoryCommand) {

        } else {
            // throw new Exception(ExceptionMessages.INVALID_COMMAND);
        }
    }
}
