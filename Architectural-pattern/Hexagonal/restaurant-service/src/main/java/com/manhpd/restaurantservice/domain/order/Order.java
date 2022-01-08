package com.manhpd.restaurantservice.domain.order;

import com.manhpd.restaurantservice.domain.repository.CustomerRepository;
import com.manhpd.restaurantservice.domain.repository.OrderRepository;
import com.manhpd.restaurantservice.domain.repository.ProductRepository;

/**
 * An aggregate root
 */
public class Order {

    private String orderId;

    private Customer customer;

    private Product product;

    private CustomerRepository customerRepository;

    private ProductRepository productRepository;

    private OrderRepository orderRepository;

    public Order(String orderId, CustomerRepository customerRepository,
                 ProductRepository productRepository,
                 OrderRepository orderRepository) {
        this.orderId = orderId;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    /**
     * lookUpCustomer looks for customer information
     * @param customerId
     */
    public void LookUpCustomer(String customerId){
        this.customer = this.customerRepository.getCustomer(customerId);
    }

    /**
     * lookUpProduct looks for product information
     * @param productId
     */
    public void lookUpProduct(String productId){
        this.product = this.productRepository.getProduct(productId);
    }

    /**
     * createOrder creates an order
     * @return
     */
    public boolean createOrder(){
        if(!this.customer.isNumberOrderAllowed()){
            return false;
        }

        return this.orderRepository.createOrder(this.orderId,this.customer);
    }

}
