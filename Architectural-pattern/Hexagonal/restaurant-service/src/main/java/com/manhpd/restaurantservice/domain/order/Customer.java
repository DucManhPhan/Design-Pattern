package com.manhpd.restaurantservice.domain.order;

/**
 * An entity
 */
public class Customer {

    private String customerId;

    private String customerName;

    private int ordersInProgress;

    private Address address;

    public Customer(String customerId, String customerName, Integer ordersInProgress,
                    String streetName, Integer streetNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.ordersInProgress = ordersInProgress;
        this.address = new Address(streetName, streetNumber);
    }

    public boolean isNumberOrderAllowed() {
        return this.ordersInProgress == 0;
    }

    public String customerId() {
        return this.customerId;
    }

}
