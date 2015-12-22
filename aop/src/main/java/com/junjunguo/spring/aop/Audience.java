package com.junjunguo.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * This file is part of aop.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 22/12/15.
 */
@Aspect
public class Audience {
    //    v 1
    //    @Before("execution(** concert.Performance.perform(..)")
    //    public void silenceCellPhones() {
    //        System.out.println("silencing cell phones.");
    //    }
    //
    //    @Before("execution(** concert.Performance.perform(..))")
    //    public void takeSeats() {
    //        System.out.println("Taking seats");
    //    }
    //
    //    @AfterReturning("execution(** concert.Performance.perform(..))")
    //    public void applause() {
    //        System.out.println("CLAP CLAP CLAP!!!");
    //    }
    //
    //    @AfterThrowing("execution(** concert.Performance.perform(..))")
    //    public void demandRefund() {
    //        System.out.println("Demanding a refund");
    //    }

    // v 2
    // the @Pointcut annotation defines a reusable pointcut within an @AspectJ aspect.
    //Define named pointcut
    @Pointcut("execution(** concert.Performance.perform(..))")
    public void performance() {}

    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }

    //    v 3
    //    Around advice is the most powerful advice type.
    // It allows you to write logic that completely wraps the advised method.
    // It’s essentially like writing both before advice and after advice in a single advice method.
    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("Silencing cell phones");
            System.out.println("Taking seats");
            jp.proceed();
            System.out.println("CLAP CLAP CLAP!!!");
        } catch (Throwable e) {
            System.out.println("Demanding a refund");
        }
    }
}
