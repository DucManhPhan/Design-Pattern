package com.manhpd.buckpal.account.adapter.out.persistence;

import com.manhpd.buckpal.account.application.port.out.LoadAccountPort;
import com.manhpd.buckpal.account.application.port.out.UpdateAccountStatePort;
import com.manhpd.buckpal.account.domain.Account;
import com.manhpd.buckpal.account.domain.Account.AccountId;
import com.manhpd.buckpal.account.domain.Activity;
import com.manhpd.buckpal.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
class AccountPersistenceAdapter implements LoadAccountPort,
                                           UpdateAccountStatePort {

    @Autowired
    private SpringDataAccountRepository accountRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account loadAccount(
            AccountId accountId,
            LocalDateTime baselineDate) {

        AccountJpaEntity account = this.accountRepository.findById(accountId.getValue())
                        .orElseThrow(EntityNotFoundException::new);
        List<ActivityJpaEntity> activities = this.activityRepository.findByOwnerSince(
                        accountId.getValue(),
                        baselineDate);
        Long withdrawalBalance = orZero(this.activityRepository
                .getWithdrawalBalanceUntil(
                        accountId.getValue(),
                        baselineDate));

        Long depositBalance = orZero(this.activityRepository
                .getDepositBalanceUntil(
                        accountId.getValue(),
                        baselineDate));

        return this.accountMapper.mapToDomainEntity(
                account,
                activities,
                withdrawalBalance,
                depositBalance);

    }

    private Long orZero(Long value){
        return value == null ? 0L : value;
    }


    @Override
    public void updateActivities(Account account) {
        for (Activity activity : account.getActivityWindow().getActivities()) {
            if (activity.getId() == null) {
                this.activityRepository.save(this.accountMapper.mapToJpaEntity(activity));
            }
        }
    }

}
