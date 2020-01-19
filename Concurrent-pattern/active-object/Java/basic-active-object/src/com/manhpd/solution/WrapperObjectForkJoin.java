package com.manhpd.solution;

import com.manhpd.problem.LegacyCode;

import java.util.concurrent.ForkJoinPool;

public class WrapperObjectForkJoin {

    private LegacyCode legacyCode;

    // container for tasks
    // decides which request to execute next
    // asyncMode=true means our worker thread processes its local task queue in the FIFO order
    // only single thread may modify internal state
    private final ForkJoinPool fj = new ForkJoinPool(1, ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, true);

    public WrapperObjectForkJoin() {
        this.legacyCode = new LegacyCode(1, 1);
    }

    public void invokeLegacyOp1() {
        fj.execute(() -> {
            legacyCode.m1();
            legacyCode.m2();

            System.out.println(legacyCode.toString());
        });
    }

    public void invokeLegacyOp2() {
        fj.execute(() -> {
            legacyCode.m2();
            legacyCode.m1();

            System.out.println(legacyCode.toString());
        });
    }

    public static void main(String[] args) throws InterruptedException {
        WrapperObjectForkJoin wrapperObjectForkJoin = new WrapperObjectForkJoin();
        wrapperObjectForkJoin.invokeLegacyOp1();
        wrapperObjectForkJoin.invokeLegacyOp2();

        Thread.sleep(5000);
    }

}
