package org.manhpd.event;

import lombok.Getter;

import java.util.Calendar;

public class DomainEvent {

    @Getter
    private final Calendar occurredOn;

    public DomainEvent() {
        this.occurredOn = Calendar.getInstance();
    }

}
