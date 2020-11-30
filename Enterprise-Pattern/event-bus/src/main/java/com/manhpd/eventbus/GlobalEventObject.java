package com.manhpd.eventbus;

public interface GlobalEventObject {

    default void restoreFromEvent(GlobalEvent event) {
        // nothing to do
    }

    default GlobalEvent getEvent() {
        return null;
    }

}
