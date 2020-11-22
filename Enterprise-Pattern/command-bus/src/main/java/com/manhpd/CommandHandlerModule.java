package com.manhpd;

import com.google.inject.AbstractModule;
import com.manhpd.handler.ICommandHandler;
import com.manhpd.handler.WithdrawCommandHandler;

public class CommandHandlerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ICommandHandler.class).to(WithdrawCommandHandler.class);
    }
}
