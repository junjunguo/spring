package com.junjunguo.spring.concert;

import java.util.List;

/**
 * This file is part of aop.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 22/12/15.
 */
public class CriticismEngineImpl implements CriticismEngine {
    private List criticisms;

    public CriticismEngineImpl() {}
    public String getCriticism() {
        int i = (int) (Math.random() * criticismPool.length);
        return criticismPool[i];
    }
    // injected
    private String[] criticismPool;
    public void setCriticismPool(String[] criticismPool) {
        this.criticismPool = criticismPool;
    }

    public void setCriticisms(List criticisms) {this.criticisms = criticisms;}

    public List getCriticisms() { return criticisms; }
}
