package com.manhpd.eventbus;

public abstract class GlobalEventObjectHandler<T extends GlobalEventObject> implements GlobalEventSubscriber {

    private Class<T> eventClazzType = null;

    public GlobalEventObjectHandler(Class<T> eventClazzType) {
        this.eventClazzType = eventClazzType;
    }

    @Override
    public void handleEvent(GlobalEvent event) {
        try {
            T eventObject = this.eventClazzType.newInstance();
            eventObject.restoreFromEvent(event);
            this.handle(eventObject);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Do not convert global event to event object: "
                    + this.eventClazzType.getName() + " " + e.getMessage());
        }
    }

    protected abstract void handle(T event);

}
