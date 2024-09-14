package br.com.rsdconsultoria.hexagonal.command.model;

public interface CommandHandler {

    void handle(Command command) throws Exception;
}
