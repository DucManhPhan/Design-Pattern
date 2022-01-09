package com.manhpd.buckpal.account.application.port.out;

import com.manhpd.buckpal.account.domain.Account.AccountId;

public interface AccountLock {

    void lockAccount(AccountId accountId);

    void releaseAccount(AccountId accountId);
}
