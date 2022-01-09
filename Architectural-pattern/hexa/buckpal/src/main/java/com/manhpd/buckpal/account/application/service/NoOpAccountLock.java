package com.manhpd.buckpal.account.application.service;

import com.manhpd.buckpal.account.application.port.out.AccountLock;
import com.manhpd.buckpal.account.domain.Account;
import org.springframework.stereotype.Component;

@Component
public class NoOpAccountLock implements AccountLock {

    @Override
    public void lockAccount(Account.AccountId accountId) {
        // nothing to do
    }

    @Override
    public void releaseAccount(Account.AccountId accountId) {
        // nothing to do
    }
}
