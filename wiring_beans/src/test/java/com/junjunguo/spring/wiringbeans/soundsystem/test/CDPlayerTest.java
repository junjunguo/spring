package com.junjunguo.spring.wiringbeans.soundsystem.test;

import com.junjunguo.spring.wiringbeans.soundsystem.CDPlayerConfig;
import com.junjunguo.spring.wiringbeans.soundsystem.CompactDisc;
import com.junjunguo.spring.wiringbeans.soundsystem.MediaPlayer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * This file is part of wiring_beans.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 20/12/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {
    @Rule
    public final StandardOutputStreamLog log =
            new StandardOutputStreamLog();
    @Autowired
    private MediaPlayer player;

    @Autowired
    private CompactDisc cd;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }

    @Test
    public void play() {
//        cd.play();
        player.play();
        assertEquals        (
                "Playing Sgt. Pepper's Lonely Hearts Club Band" +
                " by The Beatles\n",
                log.getLog());
    }
}
