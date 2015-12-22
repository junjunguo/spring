package com.junjunguo.spring.concert;

/**
 * This file is part of aop.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 22/12/15.
 */
public class Audience {

    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }
    public void takeSeats() {
        System.out.println("Taking seats");
    }
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}
