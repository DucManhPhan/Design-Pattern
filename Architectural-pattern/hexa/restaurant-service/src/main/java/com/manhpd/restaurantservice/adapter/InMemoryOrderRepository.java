package com.manhpd.restaurantservice.adapter;

import com.manhpd.restaurantservice.domain.order.Customer;
import com.manhpd.restaurantservice.domain.repository.OrderRepository;

public class InMemoryOrderRepository implements OrderRepository {

    @Override
    public boolean createOrder(String orderId, Customer customer) {
        System.out.println(String.format("Creating order %s to customer %s", orderId, customer.customerId()));
        return true;
    }
}
