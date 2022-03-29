package com.manhpd.origin;

public class Pirate {

    public void pickUpWeapon() {
        System.out.println("Pick up sword");
    }

    public void defenseAction() {
        System.out.println("Defend with sword");
    }

    public void moveToSafety() {
        System.out.println("Return to the ship");
    }

    public void defendAgainstAttack() {
        this.pickUpWeapon();
        this.defenseAction();
        this.moveToSafety();
        System.out.println();
    }

}
