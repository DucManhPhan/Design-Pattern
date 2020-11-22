package com.manhpd.handler;

import com.manhpd.command.WithdrawCommand;

public class WithdrawCommandHandler implements ICommandHandler<WithdrawCommand, Void> {

    @Override
    public Void handle(WithdrawCommand command) {
        System.out.println(WithdrawCommandHandler.class.getName() + " handled.");
        return null;
    }
}
