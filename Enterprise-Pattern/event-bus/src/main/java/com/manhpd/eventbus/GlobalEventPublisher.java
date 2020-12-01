package com.manhpd.eventbus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GlobalEventPublisher {

    private static ApplicationContext applicationContext;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        GlobalEventPublisher.applicationContext = applicationContext;
    }

    private GlobalEventPublisher() {
        // nothing to do
    }

    public static void publish(GlobalEvent event) {
        // J2EE
//        CDI.current().select(EventBus.class).get().publish(event);

        // Spring
        GlobalEventPublisher.applicationContext.getBean(EventBus.class).publish(event);
    }

}
