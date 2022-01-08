package com.manhpd.restaurantservice.adapter;

import com.manhpd.restaurantservice.domain.order.Product;
import com.manhpd.restaurantservice.domain.repository.ProductRepository;

public class InMemoryProductRepository implements ProductRepository {

    @Override
    public Product getProduct(String productId) {
        return new Product(productId, "Pizza");
    }
}
