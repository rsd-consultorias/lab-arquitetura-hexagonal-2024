package br.com.rsdconsultoria.hexagonal.query;

// Query: Representa uma operação de leitura
public class GetInvoiceQuery {
    private String invoiceId;

    public GetInvoiceQuery(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    // Getter
    public String getInvoiceId() {
        return invoiceId;
    }
}

