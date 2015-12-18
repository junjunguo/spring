package com.junjunguo.spring.knights;

/**
 * This file is part of into_action.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 18/12/15.
 */
public class BraveKnight implements Knight {
    private Quest quest;

    /**
     * @param quest BraveKnight, unlike DamselRescuingKnight, doesn’t create his own quest. Instead, he’s given a quest
     *              at construction time as a constructor argument. This is a type of DI known as constructor
     *              injection.
     */
    public BraveKnight(Quest quest) { // Quest is injected
        this.quest = quest;
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
