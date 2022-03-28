package com.manhpd.multiplication.service;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorServiceImplTest {

    private RandomGeneratorServiceImpl randomGeneratorServiceImpl;

    @Before
    public void setUp() {
        this.randomGeneratorServiceImpl = new RandomGeneratorServiceImpl();
    }

    @Test
    public void generateRandomFactorIsBetweenExpectedLimits() {
        List<Integer> randomFactors = IntStream.range(0, 1000)
                .map(i -> this.randomGeneratorServiceImpl.generateRandomFactor())
                .boxed().collect(Collectors.toList());

        assertThat(randomFactors).containsOnlyElementsOf(IntStream.range(11, 100)
                .boxed().collect(Collectors.toList()));

    }

}
