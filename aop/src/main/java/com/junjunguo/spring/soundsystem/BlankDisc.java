package com.junjunguo.spring.soundsystem;


import java.util.List;

public class BlankDisc  implements CompactDisc{

    private String title;
    private String artist;

    public BlankDisc() {
    }

    public BlankDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void play() {

    }

    public void setTrack(List tracks) {

    }

    public void playTrack(int track) {

    }
}
