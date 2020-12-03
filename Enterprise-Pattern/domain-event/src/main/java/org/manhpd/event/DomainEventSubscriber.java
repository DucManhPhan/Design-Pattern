package org.manhpd.event;

public interface DomainEventSubscriber<T> {

    void handleEvent(T occurredDomainEvent);

    Class<T> subscribedToEventType();

}
