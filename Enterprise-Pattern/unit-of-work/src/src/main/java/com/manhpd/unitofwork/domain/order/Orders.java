package com.manhpd.unitofwork.domain.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Orders {

    private String id;

    private LocalDateTime orderDate;

    private LocalDateTime requiredDate;

    private LocalDateTime shippedDate;

    private String status;

    List<OrderItems> orderItems;

}
