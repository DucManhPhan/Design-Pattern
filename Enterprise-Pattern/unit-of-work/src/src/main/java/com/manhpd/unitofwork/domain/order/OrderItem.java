package com.manhpd.unitofwork.domain.order;

import lombok.Data;

@Data
public class OrderItem {

    private Product product;

    private int quantity;

    private Money price;

    private Money discount;

}
