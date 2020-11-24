package com.manhpd.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterCommand implements ICommand<Void> {

    private String username;

    private String password;

}

