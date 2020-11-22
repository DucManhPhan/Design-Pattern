package com.manhpd.bus;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import com.manhpd.CommandHandlerModule;
import com.manhpd.command.ICommand;
import com.manhpd.handler.ICommandHandler;

public class CommandBusImpl implements ICommandBus {

    private final Injector injector;

    public CommandBusImpl() {
        this.injector = Guice.createInjector(new CommandHandlerModule());
    }

    @Override
    public <C> void execute(C command) {
        ICommandHandler<C, Void> handler = (ICommandHandler<C, Void>) findHandler(command);
        handler.handle(command);
    }

    @Override
    public <C extends ICommand<R>, R> R execute(C command) {
        ICommandHandler<C, R> handler = (ICommandHandler<C, R>) findHandler(command);
        return handler.handle(command);
    }

    private <C> ICommandHandler<C, ?> findHandler(C command) {
        Class<?> commandClazz = command.getClass();
        TypeLiteral<ICommandHandler<?, ?>> handlerType = new TypeLiteral<ICommandHandler<?, ?>>(){
             private static final long serialVersionUID = 1L;
        };

        return null;
    }
}
