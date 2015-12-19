package com.junjunguo.aop.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * This file is part of simple_aop.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 17/12/15.
 *
 */
public class AfterAdvice implements AfterReturningAdvice {
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("head off:"+method.getName()+" method");
        System.out.println("洗脚");
    }
}
