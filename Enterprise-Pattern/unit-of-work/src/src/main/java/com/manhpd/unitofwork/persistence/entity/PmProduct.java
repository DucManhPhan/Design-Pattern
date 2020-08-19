package com.manhpd.unitofwork.persistence.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
public class PmProduct {

    @Id
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity_in_stock")
    private int quantityInStock;

    @Column(name = "price")
    private BigDecimal price;

    @OneToMany(mappedBy = "products")
    private List<PmOrderItem> orderItems;

}
