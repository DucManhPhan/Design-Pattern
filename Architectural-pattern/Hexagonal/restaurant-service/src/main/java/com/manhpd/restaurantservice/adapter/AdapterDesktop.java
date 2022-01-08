package com.manhpd.restaurantservice.adapter;

import com.manhpd.restaurantservice.domain.repository.CustomerRepository;
import com.manhpd.restaurantservice.domain.repository.OrderRepository;
import com.manhpd.restaurantservice.domain.repository.ProductRepository;
import com.manhpd.restaurantservice.port.CreateOrderPort;
import com.manhpd.restaurantservice.port.CreateOrderPortImpl;
import com.manhpd.restaurantservice.port.dto.InputDto;

public class AdapterDesktop {

    private CustomerRepository customerRepository;

    private ProductRepository productRepository;

    private OrderRepository orderRepository;

    public AdapterDesktop(CustomerRepository customerRepository, ProductRepository productRepository,
                          OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    /**
     * createOrder executes creation of an order
     * @param req
     * @return
     */
    public Response createOrder(Request req){
        InputDto inputDTO = new InputDto();
        inputDTO.customerId = req.customerId;
        inputDTO.productId=req.productId;
        inputDTO.orderId=req.orderId;

        // Invokes function that the create order port exposes
        CreateOrderPort adapter = new CreateOrderPortImpl(this.customerRepository, this.productRepository,
                                                          this.orderRepository);
        Response res = new Response();
        res.result = adapter.createOrderPort(inputDTO).result;

        return res;
    }

    public static void main(String[] args) {
        CustomerRepository customerRepository = new InMemoryCustomerRepository();
        OrderRepository orderRepository = new InMemoryOrderRepository();
        ProductRepository productRepository = new InMemoryProductRepository();

        Request req = new Request("O-1234","1234","P-24244");
        AdapterDesktop adapterDesktop = new AdapterDesktop(customerRepository, productRepository, orderRepository);

        System.out.println("Before creating an order");

        Response res = adapterDesktop.createOrder(req);
        System.out.println("\nAfter creating an order the result is: "+ res.result);
    }
}
