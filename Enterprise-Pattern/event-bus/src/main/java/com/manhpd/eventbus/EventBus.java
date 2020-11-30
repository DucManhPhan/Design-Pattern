package com.manhpd.eventbus;

public interface EventBus {

    void initialize();

    void publish(GlobalEvent event);

}
