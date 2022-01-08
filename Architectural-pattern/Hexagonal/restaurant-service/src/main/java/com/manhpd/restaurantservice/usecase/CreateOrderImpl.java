package com.manhpd.restaurantservice.usecase;

import com.manhpd.restaurantservice.domain.order.Order;
import com.manhpd.restaurantservice.domain.repository.CustomerRepository;
import com.manhpd.restaurantservice.domain.repository.OrderRepository;
import com.manhpd.restaurantservice.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderImpl implements CreateOrder {

    private CustomerRepository customerRepository;

    private ProductRepository productRepository;

    private OrderRepository orderRepository;

    @Autowired
    public CreateOrderImpl(CustomerRepository customerRepository, ProductRepository productRepository,
                           OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    /**
     * createOrder executes logic required to create an order
     * @param orderId
     * @param customerId
     * @param productId
     * @return
     */
    @Override
    public boolean createOrder(String orderId, String customerId, String productId) {
        Order order = new Order(orderId, this.customerRepository,
                                this.productRepository, this.orderRepository);
        order.LookUpCustomer(customerId);
        order.lookUpProduct(productId);
        return order.createOrder();
    }

}
