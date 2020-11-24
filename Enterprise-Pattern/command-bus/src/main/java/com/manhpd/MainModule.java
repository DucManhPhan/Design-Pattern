package com.manhpd;

import com.google.inject.AbstractModule;
import com.manhpd.bus.CommandBusImpl;
import com.manhpd.bus.ICommandBus;

public class MainModule extends AbstractModule {
    @Override
    protected void configure() {
        this.install(new CommandHandlerModule());

        this.bind(ICommandBus.class).to(CommandBusImpl.class);
    }
}
