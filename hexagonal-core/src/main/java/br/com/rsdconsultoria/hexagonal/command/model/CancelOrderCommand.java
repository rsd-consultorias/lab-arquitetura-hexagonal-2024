package br.com.rsdconsultoria.hexagonal.command.model;

public class CancelOrderCommand implements Command {

    private final String correlationId;

    public CancelOrderCommand(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getCorrelationId() {
        return correlationId;
    }
}
