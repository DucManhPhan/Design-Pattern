package com.manhpd.mvendors.webservice;


import com.manhpd.mvendors.annotation.WebAdapter;
import com.manhpd.mvendors.domain.Account.AccountId;
import com.manhpd.mvendors.domain.Money;
import com.manhpd.mvendors.port_in.SendMoneyUseCase;
import com.manhpd.mvendors.port_in.SendMoneyUseCase.SendMoneyCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class SendMoneyController {

    private final SendMoneyUseCase sendMoneyUseCase;

    @PostMapping(path = "/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
    public void sendMoney(@PathVariable("sourceAccountId") Long sourceAccountId,
                          @PathVariable("targetAccountId") Long targetAccountId,
                          @PathVariable("amount") Long amount) {
        SendMoneyCommand command = new SendMoneyCommand(
                new AccountId(sourceAccountId),
                new AccountId(targetAccountId),
                Money.of(amount));

        sendMoneyUseCase.sendMoney(command);
    }

}
