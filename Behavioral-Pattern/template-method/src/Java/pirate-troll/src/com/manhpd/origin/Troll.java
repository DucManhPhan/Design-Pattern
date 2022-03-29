package com.manhpd.origin;

public class Troll {

    public void pickUpWeapon() {
        System.out.println("Pick up club");
    }

    public void defenseAction() {
        System.out.println("Defend with club");
    }

    public void moveToSafety() {
        System.out.println("Return to the mountain");
    }

    public void defendAgainstAttack() {
        this.pickUpWeapon();
        this.defenseAction();
        this.moveToSafety();
        System.out.println();
    }

}
