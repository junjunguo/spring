package com.junjunguo.spring.knights;

/**
 * This file is part of into_action.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 18/12/15.
 */
public class BraveKnight implements Knight {
    private Quest    quest;
    private Minstrel minstrel;

    /**
     * @param quest BraveKnight, unlike DamselRescuingKnight, doesn’t create his own quest. Instead, he’s given a quest
     *              at construction time as a constructor argument. This is a type of DI known as constructor
     *              injection.
     */
    public BraveKnight(Quest quest) { // Quest is injected
        this.quest = quest;
    }

    public BraveKnight(Quest quest, Minstrel minstrel) {
        this.quest = quest;
        this.minstrel = minstrel;
    }

    public void embarkOnQuest() {
        quest.embark();
    }

//    public void embarkOnQuest() {
//        minstrel.singBeforeQuest();
//        quest.embark();
//        minstrel.singAfterQuest();
//    }
}
