package com.manhpd.eventbus;

import com.manhpd.eventbus.event.RegisteredUserEventObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventBusApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EventBusApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        GlobalEvent registeredEvent = new GlobalEvent(RegisteredUserEventObject.EVENT_NAME);
        registeredEvent.setString("UserName", "Donal Trump");
        registeredEvent.setString("Password", "Ivanka Trump");
        registeredEvent.setString("PhoneNumber", "0123456789");

        GlobalEventPublisher.publish(registeredEvent);
    }
}
