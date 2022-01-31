package com.manhpd.buckpal.account.adapter.in.web;

import com.manhpd.buckpal.account.application.port.in.SendMoneyCommand;
import com.manhpd.buckpal.account.application.port.in.SendMoneyUseCase;
import com.manhpd.buckpal.account.domain.Account.AccountId;
import com.manhpd.buckpal.account.domain.Money;
import com.manhpd.buckpal.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
class SendMoneyController {

    @Autowired
    private SendMoneyUseCase sendMoneyUseCase;

    @PostMapping(path = "/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
    public void sendMoney(
            @PathVariable("sourceAccountId") Long sourceAccountId,
            @PathVariable("targetAccountId") Long targetAccountId,
            @PathVariable("amount") Long amount) {
        SendMoneyCommand command = new SendMoneyCommand(
                new AccountId(sourceAccountId),
                new AccountId(targetAccountId),
                Money.of(amount));

        this.sendMoneyUseCase.sendMoney(command);
    }

}
