package com.manhpd.mvendors.port_out;

import com.manhpd.mvendors.domain.Account;
import com.manhpd.mvendors.domain.Account.AccountId;

import java.time.LocalDateTime;

public interface LoadAccountPort {

    Account loadAccount(AccountId accountId, LocalDateTime baselineDate);

}
