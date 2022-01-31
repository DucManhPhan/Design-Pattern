package com.goahead.manhpd.refactor;

public class PlayingState implements State {

    @Override
    public void play(MediaPlayer mediaPlayer) {

    }

    @Override
    public void pause(MediaPlayer mediaPlayer) {
        mediaPlayer.setState(new PausedState());
        mediaPlayer.setIcon("play button");
        System.out.println("Video paused, icon set to " + mediaPlayer.getIcon());
    }
}
