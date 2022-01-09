package com.manhpd.buckpal.account.application.port.in;

import com.manhpd.buckpal.account.domain.Account;
import com.manhpd.buckpal.account.domain.Money;

public interface GetAccountBalanceQuery {

    Money getAccountBalance(Account.AccountId accountId);

}
