package com.manhpd.snackmachines.snackMachine.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnackMachineTest {

    @Test
    public void returnMoneyEmptiesMoneyInTransaction() {
        SnackMachine snackMachine = new SnackMachine();

        Money money = new Money(0, 0, 0, 3, 0, 0);
        snackMachine.insertMoney(money);

        snackMachine.returnMoney();
        assertEquals(snackMachine.getMoneyInTransaction().getAmount(), 0, 0);
    }

    @Test
    public void insertedMoneyGoesToMoneyInTransaction() {
        SnackMachine snackMachine = new SnackMachine();
        snackMachine.insertMoney(Money.Cent);
        snackMachine.insertMoney(Money.Dollar);

        assertEquals(snackMachine.getMoneyInTransaction().getAmount(), 1.01, 0);
    }

    @Test
    public void cannotInsertMoreThanOnCoinOrNoteAtATime() {
        SnackMachine snackMachine = new SnackMachine();
        Money twoCent = Money.add(Money.Cent, Money.Cent);

        snackMachine.insertMoney(twoCent);
    }

    @Test
    public void moneyInTransactionGoesToMoneyInsideAfterPurchase() {
        SnackMachine snackMachine = new SnackMachine();
        snackMachine.insertMoney(Money.Dollar);
        snackMachine.insertMoney(Money.Dollar);
        snackMachine.buySnack();

        assertEquals(snackMachine.getMoneyInTransaction(), Money.None);
        assertEquals(snackMachine.getMoneyInside().getAmount(), 2, 0);
    }

}