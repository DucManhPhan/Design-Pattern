package com.techbank.account.cmd.api.controllers;

import com.techbank.account.cmd.api.commands.CloseAccountCommand;
import com.techbank.account.common.dto.BaseResponse;
import com.techbank.cqrs.core.exceptions.AggregateNotFoundException;
import com.techbank.cqrs.core.infrastructure.CommandDispatcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/closeBankAccount")
public class CloseAccountController {

    @Autowired
    private CommandDispatcher commandDispatcher;

    @PutMapping(path = "/{id}")
    public ResponseEntity<BaseResponse> closeAccount(@PathVariable(value = "id") String id) {
        try {
            this.commandDispatcher.send(new CloseAccountCommand(id));
            return new ResponseEntity<>(new BaseResponse("Bank account closure request completed successfully!"), HttpStatus.OK);
        } catch (IllegalStateException | AggregateNotFoundException ex) {
            log.warn(MessageFormat.format("Client made a bad request - {0}.", ex.toString()));
            return new ResponseEntity<>(new BaseResponse(ex.toString()), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            var safeErrorMessage = MessageFormat.format("Error while processing request to close bank account with id - {0}.", id);
            log.error(safeErrorMessage, ex);
            return new ResponseEntity<>(new BaseResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
