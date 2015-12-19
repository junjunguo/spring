package com.junjunguo.aop.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * This file is part of simple_aop.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 17/12/15.
 */
public class BeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("head off:"+method.getName()+" method");
        System.out.println("OOXX");
    }
}
