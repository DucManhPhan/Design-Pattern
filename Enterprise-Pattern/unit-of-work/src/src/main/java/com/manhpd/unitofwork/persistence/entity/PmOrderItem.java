package com.manhpd.unitofwork.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@NoArgsConstructor
@Data
public class PmOrderItem {

    @EmbeddedId
    private PmOrderItemPK id;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "discount", nullable = true)
    private BigDecimal discount;

    @ManyToOne
    @MapsId("oder_id")
    @JoinColumn(name = "order_id")
    private PmOrder orders;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    private PmProduct products;

}
