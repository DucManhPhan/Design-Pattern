package com.manhpd.refactor;

public abstract class Actor {

    public abstract void pickUpWeapon();

    public abstract void defenseAction();

    public abstract void moveToSafety();

    public void defendAgainstAttack() {
        this.pickUpWeapon();
        this.defenseAction();
        this.moveToSafety();
        System.out.println();
    }

}
