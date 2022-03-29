package com.manhpd.origin;

public class Fan {

    private String state = "low";

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public void turnUp() {
        switch (this.state) {
            case "low":
                this.setState("medium");
                System.out.println("Fan is on medium");
                break;

            case "medium":
                this.setState("medium");
                System.out.println("Fan is on high");
                break;

            case "high":
                break;
        }
    }

    public void turnDown() {
        switch (this.state) {
            case "low":
                break;

            case "medium":
                this.setState("low");
                System.out.println("Fan is on low");
                break;

            case "high":
                this.setState("medium");
                System.out.println("Fan is on medium");
                break;
        }
    }

}
