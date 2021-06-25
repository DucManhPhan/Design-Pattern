package com.manhpd.snackmachines.snackMachine.domain;

import com.manhpd.snackmachines.shr.entity.Entity;

import java.util.Arrays;

public class SnackMachine extends Entity {

    private Money moneyInside = Money.None;

    private Money moneyInTransaction = Money.None;

    public void insertMoney(Money money) {
        Money[] coinsAndNotes = {
            Money.Cent, Money.TenCent, Money.Quarter,
            Money.Dollar, Money.FiveDollar, Money.TwentyDollar
        };

        if (!Arrays.asList(coinsAndNotes).contains(money)) {
            throw new IllegalStateException();
        }

        this.moneyInTransaction = Money.add(this.moneyInTransaction, money);
    }

    public void returnMoney() {
        this.moneyInTransaction = Money.None;
    }

    public void buySnack() {
        this.moneyInside = Money.add(this.moneyInside, this.moneyInTransaction);
        this.moneyInTransaction = Money.None;
    }

    public Money getMoneyInTransaction() {
        return this.moneyInTransaction;
    }

    public Money getMoneyInside() {
        return this.moneyInside;
    }

}
