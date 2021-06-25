package com.manhpd.snackmachines.snackMachine.domain;

public class SnackMachine {

    private Money moneyInside;

    private Money moneyInTransaction;

    public void insertMoney(Money money) {
        this.moneyInTransaction = Money.add(this.moneyInTransaction, money);
    }

    public void returnMoney() {

    }

    public void buySnack() {
        this.moneyInside = Money.add(this.moneyInside, this.moneyInTransaction);
    }
}
