package com.junjunguo.spring.concert;
/**
 * This file is part of aop.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 22/12/15.
 */
public class CriticAspect {


    public CriticAspect() {}
//    pointcut performance() : execution(* perform(..));
//    afterReturning() : performance() {
//        System.out.println(criticismEngine.getCriticism());
//    }


    private CriticismEngine criticismEngine;

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
