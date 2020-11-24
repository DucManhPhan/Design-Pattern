package com.manhpd.handler;

import com.manhpd.command.RegisterCommand;

public class RegisterCommandHandler implements ICommandHandler<RegisterCommand, Void> {

    @Override
    public Void handle(RegisterCommand command) {
        System.out.println(RegisterCommandHandler.class.getName() + " handled.");

        return null;
    }
}
