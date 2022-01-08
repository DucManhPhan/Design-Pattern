package com.manhpd.restaurantservice.port;

import com.manhpd.restaurantservice.domain.repository.CustomerRepository;
import com.manhpd.restaurantservice.domain.repository.OrderRepository;
import com.manhpd.restaurantservice.domain.repository.ProductRepository;
import com.manhpd.restaurantservice.port.dto.InputDto;
import com.manhpd.restaurantservice.port.dto.OutputDto;
import com.manhpd.restaurantservice.usecase.CreateOrder;
import com.manhpd.restaurantservice.usecase.CreateOrderImpl;

public class CreateOrderPortImpl implements CreateOrderPort {

    private CustomerRepository customerRepository;

    private ProductRepository productRepository;

    private OrderRepository orderRepository;

    public CreateOrderPortImpl(CustomerRepository customerRepository, ProductRepository productRepository,
                               OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public OutputDto createOrderPort(InputDto dto) {
        CreateOrder createOrder = new CreateOrderImpl(this.customerRepository, this.productRepository,
                                                      this.orderRepository);
        boolean result = createOrder.createOrder(dto.orderId, dto.customerId, dto.productId);
        OutputDto res= new OutputDto();
        if (result){
            res.result = "Creation successful";
        } else {
            res.result = "Creation failed";
        }

        return res;
    }

}
