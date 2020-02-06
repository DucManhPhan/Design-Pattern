package com.manhpd.problem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

    public static void main(String[] args) {
        LegacyCode legacyCode = new LegacyCode(1, 3);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> {
            legacyCode.m1();
            System.out.println("In thread 1, x = " + legacyCode.getX() + ", y = " + legacyCode.getY());
        });

        executor.execute(() -> {
            legacyCode.m2();
            System.out.println("In thread 2, x = " + legacyCode.getX() + ", y = " + legacyCode.getY());
        });

        executor.shutdown();
    }

}
