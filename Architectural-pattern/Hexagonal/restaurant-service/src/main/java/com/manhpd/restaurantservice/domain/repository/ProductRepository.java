package com.manhpd.restaurantservice.domain.repository;

import com.manhpd.restaurantservice.domain.order.Product;

public interface ProductRepository {
    Product getProduct(String productId);
}
