package com.manhpd.buckpal.account.application.port.out;

import com.manhpd.buckpal.account.domain.Account;
import com.manhpd.buckpal.account.domain.Account.AccountId;

import java.time.LocalDateTime;

public interface LoadAccountPort {
    Account loadAccount(AccountId accountId, LocalDateTime baselineDate);
}
