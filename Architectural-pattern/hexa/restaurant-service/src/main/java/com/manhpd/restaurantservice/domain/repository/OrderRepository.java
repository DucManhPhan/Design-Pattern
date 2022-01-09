package com.manhpd.restaurantservice.domain.repository;

import com.manhpd.restaurantservice.domain.order.Customer;

public interface OrderRepository {
    boolean createOrder(String orderId, Customer customer);
}
