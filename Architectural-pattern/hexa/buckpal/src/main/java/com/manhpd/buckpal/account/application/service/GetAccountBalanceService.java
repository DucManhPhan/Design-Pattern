package com.manhpd.buckpal.account.application.service;

import com.manhpd.buckpal.account.application.port.in.GetAccountBalanceQuery;
import com.manhpd.buckpal.account.application.port.out.LoadAccountPort;
import com.manhpd.buckpal.account.domain.Account;
import com.manhpd.buckpal.account.domain.Money;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
class GetAccountBalanceService implements GetAccountBalanceQuery {

    private final LoadAccountPort loadAccountPort;

    @Override
    public Money getAccountBalance(Account.AccountId accountId) {
        return loadAccountPort.loadAccount(accountId, LocalDateTime.now())
                .calculateBalance();
    }
}
