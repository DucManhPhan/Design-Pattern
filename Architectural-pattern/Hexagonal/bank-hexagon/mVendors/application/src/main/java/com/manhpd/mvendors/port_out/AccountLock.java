package com.manhpd.mvendors.port_out;

import com.manhpd.mvendors.domain.Account.AccountId;

public interface AccountLock {

    void lockAccount(AccountId accountId);

    void releaseAccount(AccountId accountId);

}
