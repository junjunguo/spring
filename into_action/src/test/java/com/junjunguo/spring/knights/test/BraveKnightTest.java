package com.junjunguo.spring.knights.test;

import com.junjunguo.spring.knights.BraveKnight;
import com.junjunguo.spring.knights.Quest;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * This file is part of into_action.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 18/12/15.
 */
public class BraveKnightTest {

    @Test
    public void knightShouldEmbarkOnQuest() {
        Quest       mockQuest = mock(Quest.class);              // create mock quest
        BraveKnight knight    = new BraveKnight(mockQuest);     // inject mock quest
        knight.embarkOnQuest();
        verify(mockQuest, times(1)).embark();
    }
}
