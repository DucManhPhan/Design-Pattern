package com.manhpd.buckpal.account.application.port.out;

import com.manhpd.buckpal.account.domain.Account;

public interface UpdateAccountStatePort {
    void updateActivities(Account account);
}
