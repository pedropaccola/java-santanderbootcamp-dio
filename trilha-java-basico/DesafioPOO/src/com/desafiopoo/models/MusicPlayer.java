package com.desafiopoo.models;

public class MusicPlayer implements Player {
    @Override
    public void play() {
        System.out.println("Playing music");
    }

    @Override
    public void pause() {
        System.out.println("Pausing music");
    }

    public void selectMedia() {
        System.out.println("Selecting a song");
    }
}
