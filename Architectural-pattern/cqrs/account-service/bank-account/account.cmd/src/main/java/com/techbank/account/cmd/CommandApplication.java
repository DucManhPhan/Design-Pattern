package com.techbank.account.cmd;

import com.techbank.account.cmd.api.commands.*;
import com.techbank.cqrs.core.infrastructure.CommandDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CommandApplication {

	@Autowired
	private CommandDispatcher commandDispatcher;

	@Autowired
	private CommandHandler commandHandler;

	public static void main(String[] args) {
		SpringApplication.run(CommandApplication.class, args);
	}

	@PostConstruct
	public void registerHandlers() {
		this.commandDispatcher.registerHandler(OpenAccountCommand.class, commandHandler::handle);
		this.commandDispatcher.registerHandler(DepositFundsCommand.class, commandHandler::handle);
		this.commandDispatcher.registerHandler(WithdrawFundsCommand.class, commandHandler::handle);
		this.commandDispatcher.registerHandler(CloseAccountCommand.class, commandHandler::handle);
	}

}
