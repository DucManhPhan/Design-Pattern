package com.manhpd.mvendors.port_in;

import com.manhpd.mvendors.domain.Account.AccountId;
import com.manhpd.mvendors.domain.Money;

public interface GetAccountBalanceQuery {

    Money getAccountBalance(AccountId accountId);

}
