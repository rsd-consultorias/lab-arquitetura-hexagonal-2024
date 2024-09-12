package br.com.rsdconsultoria.hexagonal.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

/**
 * Model
 */
public class Invoice {
    private String number;
    private String customerName;
    private String customerCNPJ;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private BigDecimal totalAmount;
    private BigDecimal taxAmount;
    private String description;
    private String paymentMethod;
    private Collection<Item> items;

    public void markAsPaid() {

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCNPJ() {
        return customerCNPJ;
    }

    public void setCustomerCNPJ(String customerCNPJ) {
        this.customerCNPJ = customerCNPJ;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }
}
