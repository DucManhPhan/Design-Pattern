package com.manhpd.unitofwork.domain.repository;

import com.manhpd.unitofwork.domain.order.Order;

public interface OrderRepository {

    void insert(Order order);

}
