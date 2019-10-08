package com.manhpd.command;

import com.manhpd.receiver.Receiver;

public class Command1 implements ICommand {

    private Receiver receiver;

    public Command1(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.doAction1();
    }
}
