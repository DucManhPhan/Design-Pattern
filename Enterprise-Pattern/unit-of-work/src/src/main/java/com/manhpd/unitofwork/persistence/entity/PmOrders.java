package com.manhpd.unitofwork.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Data
public class PmOrders {

    @Id
    @Column(name = "order_id")
    private int id;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "required_date")
    private LocalDateTime requiredDate;

    @Column(name = "shipped_date")
    private LocalDateTime shippedDate;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PmOrderItems> orderItems;


}
