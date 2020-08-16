package com.manhpd.unitofwork.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@NoArgsConstructor
@Data
public class OrderItems {

    @EmbeddedId
    private OrderItemsPK id;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "discount", nullable = true)
    private BigDecimal discount;

}
