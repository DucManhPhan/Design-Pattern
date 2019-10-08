package com.manhpd.invoker;

import com.manhpd.command.ICommand;

import java.util.HashMap;
import java.util.Map;

public class Invoker {

    private static Map<CommandType, ICommand> commands = new HashMap<>();

    public void register(CommandType type, ICommand command) {
        commands.put(type, command);
    }

    public void unregister(CommandType type) {
        commands.remove(type);
    }

    public void execute(CommandType type) {
        ICommand command = commands.get(type);
        command.execute();
    }

}
