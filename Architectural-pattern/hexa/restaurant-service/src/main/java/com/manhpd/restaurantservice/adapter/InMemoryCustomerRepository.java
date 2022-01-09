package com.manhpd.restaurantservice.adapter;

import com.manhpd.restaurantservice.domain.order.Customer;
import com.manhpd.restaurantservice.domain.repository.CustomerRepository;

public class InMemoryCustomerRepository implements CustomerRepository {

    @Override
    public Customer getCustomer(String customerId) {
        return new Customer(customerId, "DDD", 0, "educative", 1);
    }
}
