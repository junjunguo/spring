package com.junjunguo.spring.knights;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This file is part of into_action.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 18/12/15.
 */
public class KnightMain {

    public static void main(String[] args) throws Exception {
        KnightMain km = new KnightMain();
        System.out.println("runBean: ");
        km.runBean();
        System.out.println("\n--\n");
        km.run();
    }

    private void run() {
        System.out.println("run as POJO:");
        Quest  quest  = new SlayDragonQuest(System.out);    // create quest and inject System.out
        Knight knight = new BraveKnight(quest);             // create Knight and inject quest
        knight.embarkOnQuest();                             // run the method
    }

    public void runBean() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/knight.xml");

//                AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);

        Knight knight = context.getBean(Knight.class);      // quest is created at configuration
        knight.embarkOnQuest();
        context.close();
    }
}
