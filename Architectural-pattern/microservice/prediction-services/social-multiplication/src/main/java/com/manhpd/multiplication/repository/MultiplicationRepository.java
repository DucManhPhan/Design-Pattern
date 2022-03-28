package com.manhpd.multiplication.repository;

import com.manhpd.multiplication.domain.Multiplication;
import org.springframework.data.repository.CrudRepository;

public interface MultiplicationRepository extends CrudRepository<Multiplication, Long> {
}
