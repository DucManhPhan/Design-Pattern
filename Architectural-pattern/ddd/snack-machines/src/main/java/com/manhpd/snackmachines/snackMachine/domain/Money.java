package com.manhpd.snackmachines.snackMachine.domain;

import com.manhpd.snackmachines.shr.valueObject.ValueObject;

public class Money extends ValueObject<Money> {

    public static final Money None = new Money(0, 0, 0, 0, 0, 0);

    public static final Money Cent = new Money(1, 0, 0, 0, 0, 0);

    public static final Money TenCent = new Money(0, 1, 0, 0, 0, 0);

    public static final Money Quarter = new Money(0, 0, 1, 0, 0, 0);

    public static final Money Dollar = new Money(0, 0, 0, 1, 0, 0);

    public static final Money FiveDollar = new Money(0, 0, 0, 0, 1, 0);

    public static final Money TwentyDollar = new Money(0, 0, 0, 0, 1, 1);

    private final int oneCentCount;

    private final int tenCentCount;

    private final int quarterCount;

    private final int oneDollarCount;

    private final int fiveDollarCount;

    private final int twentyDollarCount;

    private float amount;

    public Money(int oneCentCount, int tenCentCount, int quarterCount,
                 int oneDollarCount, int fiveDollarCount, int twentyDollarCount) {
        if (oneCentCount < 0) {
            throw new IllegalStateException();
        }

        if (tenCentCount < 0) {
            throw new IllegalStateException();
        }

        if (quarterCount < 0) {
            throw new IllegalStateException();
        }

        if (oneDollarCount < 0) {
            throw new IllegalStateException();
        }

        if (fiveDollarCount < 0) {
            throw new IllegalStateException();
        }

        if (twentyDollarCount < 0) {
            throw new IllegalStateException();
        }

        this.oneCentCount = oneCentCount;
        this.tenCentCount = tenCentCount;
        this.quarterCount = quarterCount;

        this.oneDollarCount = oneDollarCount;
        this.fiveDollarCount = fiveDollarCount;
        this.twentyDollarCount = twentyDollarCount;
    }

    public static Money add(Money money1, Money money2) {
        Money sum = new Money(
                money1.oneCentCount + money2.oneCentCount,
                money1.tenCentCount + money2.tenCentCount,
                 money1.quarterCount + money2.quarterCount,
                  money1.oneDollarCount + money2.oneDollarCount,
                  money1.fiveDollarCount + money2.fiveDollarCount,
                money1.twentyDollarCount + money2.twentyDollarCount);

        return sum;
    }

    public Money subtract(Money other) {
        return new Money(
                this.oneCentCount - other.oneCentCount,
                this.tenCentCount - other.tenCentCount,
                this.quarterCount - other.quarterCount,
                this.oneDollarCount - other.quarterCount,
                this.fiveDollarCount - other.fiveDollarCount,
                this.twentyDollarCount - other.twentyDollarCount
        );
    }

    @Override
    protected boolean equalsCore(Money other) {
        return this.oneCentCount == other.oneCentCount
                && this.tenCentCount == other.tenCentCount
                && this.quarterCount == other.quarterCount
                && this.oneDollarCount == other.oneDollarCount
                && this.fiveDollarCount == other.fiveDollarCount
                && this.twentyDollarCount == other.twentyDollarCount;
    }

    @Override
    protected int getHashCodeCore() {
        int hashCode = oneCentCount;
        hashCode = (hashCode * 397) ^ tenCentCount;
        hashCode = (hashCode * 397) ^ quarterCount;
        hashCode = (hashCode * 397) ^ oneDollarCount;
        hashCode = (hashCode * 397) ^ fiveDollarCount;
        hashCode = (hashCode * 397) ^ twentyDollarCount;

        return hashCode;
    }

    public float getAmount() {
        return this.oneCentCount * 0.01f + this.tenCentCount * 0.1f +
               this.quarterCount * 0.25f + this.oneDollarCount * 1f +
               this.fiveDollarCount * 5f + this.twentyDollarCount * 20f;
    }

    public int getOneCentCount() {
        return oneCentCount;
    }

    public int getTenCentCount() {
        return tenCentCount;
    }

    public int getQuarterCount() {
        return quarterCount;
    }

    public int getOneDollarCount() {
        return oneDollarCount;
    }

    public int getFiveDollarCount() {
        return fiveDollarCount;
    }

    public int getTwentyDollarCount() {
        return twentyDollarCount;
    }
}
