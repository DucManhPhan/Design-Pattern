package com.goahead.manhpd.origin;

public class MediaPlayer {
    private String state = "paused";
    private String icon = "play button";

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void play() {
        switch (this.state) {
            case "paused":
                this.setState("playing");
                this.setIcon("pause button");
                System.out.println("Video playing, icon set to " + this.getIcon());
                break;

            case "playing":
                break;
        }
    }

    public void pause() {
        switch (this.state) {
            case "paused":
                break;

            case "playing":
                this.setState("paused");
                this.setIcon("play button");
                System.out.println("Video paused, icon set to " + this.getIcon());
                break;
        }
    }
}
