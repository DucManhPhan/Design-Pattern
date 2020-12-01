package com.manhpd.eventbus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class EventBusImpl implements EventBus {

    private Boolean isInit = Boolean.FALSE;

    private Map<String, List<GlobalEventSubscriber>> eventSubscriberMap = null;

    private ApplicationContext applicationContext;

    @Autowired
    public EventBusImpl(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    @PostConstruct
    public void initialize() {
        Map<String, GlobalEventSubscriber> subscribers =
                this.applicationContext.getBeansOfType(GlobalEventSubscriber.class);
        this.eventSubscriberMap = subscribers.values().stream()
                                             .collect(Collectors.groupingBy(subscriber -> {
                                                 GlobalEventHandler annotation = subscriber.getClass().getAnnotation(GlobalEventHandler.class);
                                                 if (Objects.isNull(annotation)) {
                                                     throw new RuntimeException("Do not exist subscriber annotation.");
                                                 }

                                                 return annotation.value();
                                             }));
        this.isInit = true;
    }

    @Override
    public void publish(GlobalEvent event) {
        if (!this.isInit) {
            throw new RuntimeException("Not init event bus");
        }

        List<GlobalEventSubscriber> eventSubscribers = this.eventSubscriberMap.getOrDefault(event.getEventName(), new ArrayList<>());
        eventSubscribers.forEach(subscriber -> {
            subscriber.handleEvent(event);
        });
    }

    @PreDestroy
    public void destroy() {
        this.isInit = false;
        this.eventSubscriberMap.clear();
    }


}
