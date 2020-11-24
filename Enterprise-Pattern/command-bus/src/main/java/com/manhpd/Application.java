package com.manhpd;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.manhpd.bus.ICommandBus;
import com.manhpd.command.WithdrawCommand;

public class Application {
    public static void main( String[] args ) {
        Injector injectorHandler = Guice.createInjector(new MainModule());
        ICommandBus commandBus = injectorHandler.getInstance(ICommandBus.class);

        WithdrawCommand command = new WithdrawCommand("John", "100000", "john");
        commandBus.execute(command);
    }
}
