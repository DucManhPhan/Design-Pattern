package com.manhpd.client;

import com.manhpd.command.Command1;
import com.manhpd.command.Command2;
import com.manhpd.command.ICommand;
import com.manhpd.invoker.CommandType;
import com.manhpd.invoker.Invoker;
import com.manhpd.receiver.Receiver;

public class Application {

    public static void main(String[] args) {
        // Create Receiver to actually do action
        Receiver receiver = new Receiver();

        // Create commands
        ICommand command1 = new Command1(receiver);
        ICommand command2 = new Command2(receiver);

        // Put commands into Invoker
        Invoker invoker = new Invoker();

        invoker.register(CommandType.ACTION_1, command1);
        invoker.register(CommandType.ACTION_2, command2);

        invoker.execute(CommandType.ACTION_1);
        invoker.execute(CommandType.ACTION_2);
    }
}
