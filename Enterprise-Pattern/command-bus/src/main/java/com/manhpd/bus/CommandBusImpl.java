package com.manhpd.bus;

import com.google.inject.Inject;
import com.google.inject.TypeLiteral;
import com.manhpd.command.ICommand;
import com.manhpd.handler.ICommandHandler;
import com.manhpd.utils.CommandHandlerNotFoundException;
import com.manhpd.utils.HandlerUtils;

import java.util.Set;

public class CommandBusImpl implements ICommandBus {

    private Set<ICommandHandler> commandHandlers;

    @Inject
    public CommandBusImpl(Set<ICommandHandler> commandHandlers) {
        this.commandHandlers = commandHandlers;
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

        return this.commandHandlers.stream()
                            .filter(handler -> HandlerUtils.canHandle(handler.getClass(), commandClazz))
                            .findFirst()
                            .orElseThrow(() -> new CommandHandlerNotFoundException(command));
    }

//    private void closeAll(Injector injector) {
//        for(Map.Entry<Key<?>, Binding<?>> entry : injector.getAllBindings().entrySet()) {
//            final Binding<?> binding = entry.getValue();
//            if (Closeable.class.isAssignableFrom(
//                    entry.getKey().getTypeLiteral().getRawType())) {
//                binding.accept(new DefaultBindingScopingVisitor<Void>() {
//                    @Override public Void visitEagerSingleton() {
//                        Closeable instance = (Closeable) (binding.getProvider().get());
//                        try {
//                            instance.close();
//                        } catch (IOException e) {
//                            // log this?
//                        }
//                        return null;
//                    }
//                });
//            }
//        }
//    }

}
