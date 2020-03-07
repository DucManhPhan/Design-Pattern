package com.manhpd.mvendors.port_in;

import com.manhpd.mvendors.annotation.SelfValidating;
import com.manhpd.mvendors.domain.Account.AccountId;
import com.manhpd.mvendors.domain.Money;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotNull;

public interface SendMoneyUseCase {

    boolean sendMoney(SendMoneyCommand command);

    @Value
    @EqualsAndHashCode(callSuper = false)
    class SendMoneyCommand extends SelfValidating<SendMoneyCommand> {

        @NotNull
        private final AccountId sourceAccountId;

        @NotNull
        private final AccountId targetAccountId;

        @NotNull
        private final Money money;

        public SendMoneyCommand(AccountId sourceAccountId,
                                AccountId targetAccountId,
                                Money money) {
            this.sourceAccountId = sourceAccountId;
            this.targetAccountId = targetAccountId;
            this.money = money;
        }
    }


}
