package com.manhpd.unitofwork.domain.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private int id;

    private String productName;

    private String description;

    private int quantityInStock;

    private Money price;

}
