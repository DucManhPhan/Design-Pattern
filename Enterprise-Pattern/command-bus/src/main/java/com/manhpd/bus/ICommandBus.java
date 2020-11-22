package com.manhpd.bus;

import com.manhpd.command.ICommand;

public interface ICommandBus {

    <C> void execute(C command);

    <C extends ICommand<R>, R> R execute(C command);

}
