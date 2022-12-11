package com.techbank.account.cmd.api.controllers;

import com.techbank.account.cmd.api.commands.DepositFundsCommand;
import com.techbank.account.cmd.api.commands.WithdrawFundsCommand;
import com.techbank.account.common.dto.BaseResponse;
import com.techbank.cqrs.core.exceptions.AggregateNotFoundException;
import com.techbank.cqrs.core.infrastructure.CommandDispatcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/withdrawFunds")
public class WithdrawFundsController {

    @Autowired
    private CommandDispatcher commandDispatcher;

    @PutMapping(path = "/{id}")
    public ResponseEntity<BaseResponse> withdrawFunds(@PathVariable(value = "id") String id,
                                                     @RequestBody WithdrawFundsCommand command) {
        try {
            command.setId(id);
            this.commandDispatcher.send(command);
            return new ResponseEntity<>(new BaseResponse("Withdraw funds request completed successfully!"), HttpStatus.OK);
        } catch (IllegalStateException | AggregateNotFoundException ex) {
            log.warn(MessageFormat.format("Client made a bad request - {0}.", ex.toString()));
            return new ResponseEntity(new BaseResponse(ex.toString()), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            var safeErrorMessage = MessageFormat.format("Error while processing request to withdraw funds to bank account with id - {0}.", id);
            log.error(safeErrorMessage, ex);
            return new ResponseEntity<>(new BaseResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
