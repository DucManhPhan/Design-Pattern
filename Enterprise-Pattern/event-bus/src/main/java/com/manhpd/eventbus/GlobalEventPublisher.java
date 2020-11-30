package com.manhpd.eventbus;

public class GlobalEventPublisher {

    private GlobalEventPublisher() {
        // nothing to do
    }

    public static void publish(GlobalEvent event) {
        // J2EE
//        CDI.current().select(EventBus.class).get().publish(event);

        // Spring

    }

}
