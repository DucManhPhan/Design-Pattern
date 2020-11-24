package com.manhpd;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import com.manhpd.handler.ICommandHandler;
import com.manhpd.handler.RegisterCommandHandler;
import com.manhpd.handler.WithdrawCommandHandler;

public class CommandHandlerModule extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder<ICommandHandler> commandHandlerBinder = Multibinder.newSetBinder(binder(), ICommandHandler.class);
        commandHandlerBinder.addBinding().to(RegisterCommandHandler.class);
        commandHandlerBinder.addBinding().to(WithdrawCommandHandler.class);
    }
}
