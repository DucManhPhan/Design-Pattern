package com.manhpd.command;

import com.manhpd.receiver.Receiver;

public class Command2 implements ICommand {

    private Receiver receiver;

    public Command2(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.doAction2();
    }
}
