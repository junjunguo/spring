package com.junjunguo.spring.soundsystem;

import java.util.List;

/**
 * This file is part of wiring_beans.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 20/12/15.
 */
public interface CompactDisc {
    void play();

    void setTrack(List tracks);

    void playTrack(int track);
}
