package org.manhpd.event;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DomainEventContext {

    private final List occurredEvents = new ArrayList();

    private DomainEventContext() {
        DomainEventPublisher.instance().reset();
    }

    public static DomainEventContext start(Runnable process) {
        DomainEventContext context = new DomainEventContext();
        DomainEventPublisher.instance().subscribe(DomainEvent.class, e -> context.occurredEvents.add(e));

        process.run();
        return context;
    }

    public <T> DomainEventContext handle(Class<T> eventTypeHandle, Consumer<T> eventHandler) {
        this.occurredEvents.stream()
                           .filter(e -> e.getClass() == eventTypeHandle)
                           .forEach(e -> eventHandler.accept((T) e));
        return this;
    }
}
