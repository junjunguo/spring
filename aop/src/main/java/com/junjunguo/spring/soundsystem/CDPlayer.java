package com.junjunguo.spring.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * This file is part of wiring_beans.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 20/12/15.
 */
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;


    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }

    @Autowired
    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

    @Autowired
    public void insertDisc(CompactDisc cd) {
        this.cd = cd;
    }
}
