package com.manhpd.handler;

public interface ICommandHandler<C, R> {

    R handle(C command);

}
