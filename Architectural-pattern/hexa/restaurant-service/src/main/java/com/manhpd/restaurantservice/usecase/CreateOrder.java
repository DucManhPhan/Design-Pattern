package com.manhpd.restaurantservice.usecase;

public interface CreateOrder {
    boolean createOrder(String orderId, String customerId, String productId);
}
