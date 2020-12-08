package com.manhpd;

import com.google.common.eventbus.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventBusTest {

    private static class Event1 {
        @Override
        public String toString() {
            return Event1.class.getName();
        }
    }

    private static class Event2 {
        @Override
        public String toString() {
            return "Event 2";
        }
    }

    private static class EventX {
        @Override
        public String toString() {
            return "Event X";
        }
    }

    private static class EventListener {
        @Subscribe
        @AllowConcurrentEvents
        public void onEvent(Event1 event1) throws InterruptedException {
            String name = Thread.currentThread().getName();
            System.out.println(name + " sleep A little while");
            Thread.sleep(1000);
            System.out.println(name + "===Subscription Event 1,Receive:" + event1);
        }

        @Subscribe
        public void onEvent(Event2 event2) throws InterruptedException {
            String name = Thread.currentThread().getName();
            System.out.println(name + " sleep A little while");
            Thread.sleep(1000);
            System.out.println(name + "===Subscription Event 2,Receive:" + event2);
        }

        @Subscribe
        public void onEvent(DeadEvent deadEvent) throws InterruptedException {
            String name = Thread.currentThread().getName();
            Thread.sleep(10*1000);
            System.out.println(name + "===Subscription error events,Receive:" + deadEvent);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String name = Thread.currentThread().getName();
        EventBus eb = new EventBus();

        eb.register(new EventListener());
        System.out.println(name + "----------Sending events X---------");

        eb.post(new EventX());
        System.out.println(name + "----------Send Event 1----Parallel reception-----");

        ExecutorService threadPool = Executors.newCachedThreadPool();
        eb = new AsyncEventBus(threadPool);
        eb.register(new EventListener());

        for (int i = 0; i < 10; i++) {
            eb.post(new Event1());
        }

        Thread.sleep(2000);
        System.out.println(name + "----------Send Event 2----Serial reception-----");
        for (int i = 0; i < 10; i++) {
            eb.post(new Event2());
        }

        Thread.sleep(2000);
        threadPool.shutdown();
    }

}
