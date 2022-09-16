package com.manh.cashflow.database.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
@Data
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "due_date")
    private String dueDate;

    @Column(name = "amount")
    private BigDecimal amount;

}
