package com.manhpd.utils;

public class CommandHandlerNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CommandHandlerNotFoundException(Object command) {
        super(String.format("Not found CommandHandler: %s", command.getClass().getName()));
    }

}
