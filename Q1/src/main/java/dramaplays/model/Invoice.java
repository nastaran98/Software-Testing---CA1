package src.main.java.dramaplays.model;

import java.util.List;

public class Invoice {

    public String customer;
    public List<Performance> performances;

    public Invoice(String customer, List<Performance> performances) {
        if (customer == null || customer.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer cannot be null or empty");
        }
        this.customer = customer;
        this.performances = performances == null ? List.of() : List.copyOf(performances); // Allow null and create an immutable copy if not null
    }

    public String getCustomer() {
        return customer;
    }

    public List<Performance> getPerformances() {
        return List.copyOf(performances); // Return an immutable copy
    }
}
