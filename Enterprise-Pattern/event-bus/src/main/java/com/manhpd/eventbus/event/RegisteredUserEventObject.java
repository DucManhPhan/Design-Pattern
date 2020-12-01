package com.manhpd.eventbus.event;

import com.manhpd.eventbus.GlobalEvent;
import com.manhpd.eventbus.GlobalEventObject;

public class RegisteredUserEventObject implements GlobalEventObject {

    public static final String EVENT_NAME = "RegisteredUserEventObject";

    private String userName;

    private String password;

    private String phoneNumber;

    public RegisteredUserEventObject() {
        // nothing to do
    }

    public RegisteredUserEventObject(String userName, String password, String phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public GlobalEvent getEvent() {
        GlobalEvent event = new GlobalEvent(EVENT_NAME);
        event.setString("UserName", this.userName);
        event.setString("Password", this.password);
        event.setString("PhoneNumber", this.phoneNumber);

        return event;
    }

    @Override
    public void restoreFromEvent(GlobalEvent event) {
        this.userName = event.getString("UserName");
        this.password = event.getString("Password");
        this.phoneNumber = event.getString("PhoneNumber");
    }

}
