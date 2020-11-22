package com.manhpd.command;

public class WithdrawCommand {

    private String username;

    private String amount;

    private String account;

    public WithdrawCommand() {
        // nothing to do
    }

    public WithdrawCommand(String username, String amount, String account) {
        this.username = username;
        this.amount = amount;
        this.account = account;
    }
}
