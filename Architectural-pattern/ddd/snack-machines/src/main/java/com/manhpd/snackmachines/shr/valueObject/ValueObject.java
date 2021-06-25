package com.manhpd.snackmachines.shr.valueObject;

public abstract class ValueObject<T> {

    @Override
    public boolean equals(Object obj) {
        T valueObject = (T) obj;

        if (valueObject == null) {
            return false;
        }

        return this.equalsCore(valueObject);
    }

    @Override
    public int hashCode() {
        return this.getHashCodeCore();
    }

    protected abstract boolean equalsCore(T valueObject);

    protected abstract int getHashCodeCore();

}
