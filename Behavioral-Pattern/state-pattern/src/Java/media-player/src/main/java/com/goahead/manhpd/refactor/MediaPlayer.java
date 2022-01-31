package com.goahead.manhpd.refactor;

public class MediaPlayer {

    private State state = new PausedState();

    private String icon = "play button";

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void play() {
        this.state.play(this);
    }

    public void pause() {
        this.state.pause(this);
    }

}
