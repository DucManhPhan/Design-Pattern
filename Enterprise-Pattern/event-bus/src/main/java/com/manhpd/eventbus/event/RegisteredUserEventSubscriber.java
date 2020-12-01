package com.manhpd.eventbus.event;

import com.manhpd.eventbus.GlobalEventHandler;
import com.manhpd.eventbus.GlobalEventObjectHandler;
import com.manhpd.eventbus.GlobalEventSubscriber;
import org.springframework.stereotype.Component;

@Component
@GlobalEventHandler(RegisteredUserEventObject.EVENT_NAME)
public class RegisteredUserEventSubscriber extends GlobalEventObjectHandler<RegisteredUserEventObject> implements GlobalEventSubscriber {

    public RegisteredUserEventSubscriber() {
        super(RegisteredUserEventObject.class);
    }

    @Override
    protected void handle(RegisteredUserEventObject event) {
        System.out.println(RegisteredUserEventSubscriber.class.getName() + " handled");
    }
}
