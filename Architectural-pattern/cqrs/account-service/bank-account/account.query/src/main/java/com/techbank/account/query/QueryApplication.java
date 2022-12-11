package com.techbank.account.query;

import com.techbank.account.query.api.queries.*;
import com.techbank.cqrs.core.infrastructure.QueryDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class QueryApplication {

	@Autowired
	private QueryDispatcher queryDispatcher;

	@Autowired
	private QueryHandler queryHandler;

	public static void main(String[] args) {
		SpringApplication.run(QueryApplication.class, args);
	}

	@PostConstruct
	public void registerHandlers() {
		this.queryDispatcher.registerHandler(FindAllAccountsQuery.class, this.queryHandler::handle);
		this.queryDispatcher.registerHandler(FindAccountByIdQuery.class, this.queryHandler::handle);
		this.queryDispatcher.registerHandler(FindAccountByHolderQuery.class, this.queryHandler::handle);
		this.queryDispatcher.registerHandler(FindAccountWithBalanceQuery.class, this.queryHandler::handle);
	}

}
