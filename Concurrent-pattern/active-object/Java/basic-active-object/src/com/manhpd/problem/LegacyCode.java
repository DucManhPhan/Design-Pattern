package com.manhpd.problem;

public class LegacyCode {

    private int x;

    private int y;

    public LegacyCode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    private void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void m1() {
        setX(9);
        setY(0);
    }

    public void m2() {
        setY(9);
        setX(0);
    }

    @Override
    public String toString() {
        return "x = " + this.x + ", y = " + this.y;
    }
}
