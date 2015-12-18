package com.junjunguo.spring.knights;

/**
 * This file is part of into_action.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 18/12/15.
 */
public class DamselRescuingKnight implements Knight {
    private RescueDamselQuest quest;


    public DamselRescuingKnight() {
        // Tightly coupled to RescueDamselQuest:
        // tightly coupled code is difficult to test, difficult to reuse, and difficult to understand
        this.quest = new RescueDamselQuest();
    }

//    public DamselRescuingKnight(RescueDamselQuest quest) {
    //        // loosely coupled
    //        this.quest = quest;
    //    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
