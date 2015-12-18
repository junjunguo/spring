package com.junjunguo.spring.knights;

import java.io.PrintStream;

/**
 * This file is part of into_action.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 18/12/15.
 */
public class SlayDragonQuest implements Quest {
    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    public void embark() {
        stream.println("Embarking on quest to slay the dragon!");
    }
}
