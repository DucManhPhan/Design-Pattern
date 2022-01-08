package org.manhpd.event;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DomainEventPublisher {

    private static final ThreadLocal<DomainEventPublisher> instance = new ThreadLocal<DomainEventPublisher>() {
        @Override
        protected DomainEventPublisher initialValue() {
            return new DomainEventPublisher();
        }
    };

    private final List subscribers = new ArrayList<>();

    private boolean publishing = false;

    private DomainEventPublisher() {
        // nothing to do
    }

    public static DomainEventPublisher instance() {
        return instance.get();
    }

    public <T> void publish(T publishingEvent) {
        if (this.isPublishing()) {
            throw new IllegalStateException("Publishing event");
        }

        try {
            this.publishingStarted();

            Class<?> publishingEventType = publishingEvent.getClass();
            List<DomainEventSubscriber<T>> allSubscribers = this.subscribers();

            for (DomainEventSubscriber<T> subscriber : allSubscribers) {
                Class<?> subscribedToType = subscriber.subscribedToEventType();

                if (publishingEventType == subscribedToType || subscribedToType == DomainEvent.class) {
                    subscriber.handleEvent(publishingEvent);
                }
            }
        } finally {
            this.publishingFinished();
        }
    }

    void reset() {
        if (this.isPublishing()) {
            throw new IllegalStateException("Publishing event");
        }

        this.subscribers.clear();
    }

    <T> void subscribe(Class<T> eventType, Consumer<T> eventHandler) {
        DomainEventSubscriber<T> subscriber = new DomainEventSubscriber<T>() {

            @Override
            public void handleEvent(T domainEvent) {
                eventHandler.accept(domainEvent);
            }

            @Override
            public Class<T> subscribedToEventType() {
                return eventType;
            }
        };

        this.registerSubscriber(subscriber);
    }

    private <T> void registerSubscriber(DomainEventSubscriber<T> subscriber) {
        if (this.isPublishing()) {
            throw new IllegalStateException("");
        }

        this.subscribers().add(subscriber);
    }

    private boolean isPublishing() {
        return this.publishing;
    }

    private void publishingStarted() {
        this.publishing = true;
    }

    private void publishingFinished() {
        this.publishing = false;
    }

    private List subscribers() {
        return this.subscribers;
    }

}
