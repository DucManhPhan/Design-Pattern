package com.manhpd.solution;

import com.manhpd.problem.LegacyCode;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class WrapperObject {

    private LegacyCode legacyCode;

    private BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();

    private Thread processorThread;

    public WrapperObject() {
        this.legacyCode = new LegacyCode(1, 1);
    }

    public synchronized void m1() {
        this.legacyCode.m1();
    }

    public synchronized void m2() {
        this.legacyCode.m2();
    }

    public void startTheActiveObject() {
        this.processorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        queue.take().run();
                    } catch (InterruptedException ex) {
                        System.out.println("Active Object done!");
                        break;
                    }
                }
            }
        });

        this.processorThread.start();
    }

    private void invokeLegacyOp1() throws InterruptedException {
        this.queue.put(new Runnable() {
            @Override
            public void run() {
                legacyCode.m1();
                legacyCode.m2();
            }
        });
    }

    private void invokeLegacyOp2() throws InterruptedException {
        this.queue.put(new Runnable() {
            @Override
            public void run() {
                legacyCode.m2();
                legacyCode.m1();
            }
        });
    }

    private void stop() {
        this.processorThread.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        WrapperObject wrapperObject = new WrapperObject();
        wrapperObject.startTheActiveObject();

        wrapperObject.invokeLegacyOp1();
//        wrapperObject.invokeLegacyOp2();

        Thread.sleep(5000);
        wrapperObject.stop();
    }

}
