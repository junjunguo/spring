package com.junjunguo.spring.soundsystem;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This file is part of wiring_beans.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 20/12/15.
 * <p/>
 * SgtPeppers is annotated with @Component. This simple annotation identifies this class as a component class and serves
 * as a clue to Spring that a bean should be created for the class. There’s no need to explicitly configure a SgtPeppers
 * bean; Spring will do it for you because this class is annotated with @Component.
 */
@Component
public class SgtPeppers implements CompactDisc, MediaPlayer {
    private String title  = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";
//    private List   tracks = new ArrayList();

    public void play() {

        System.out.println("Playing " + title + " by " + artist);

    }

    public void setTrack(List tracks) {
//        this.tracks = tracks;
    }
//
    public void playTrack(int track) {
//        System.out.println(tracks.get(track));
    }
}
