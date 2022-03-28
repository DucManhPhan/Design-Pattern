package com.manhpd.multiplication.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity(name = "pMultiplication")
public final class Multiplication {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "MULTIPLICATION_ID")
    private Long id;

    private final int factorA;

    private final int factorB;

    public Multiplication() {
        this(0, 0);
    }

}
