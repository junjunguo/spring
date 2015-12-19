package com.junjunguo.aop.advice;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * This file is part of simple_aop.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 17/12/15.
 */
public class CompareAdvice implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object result = null;
        String userName = invocation.getArguments()[0].toString();
        if (null != userName && userName.equals("yuanzhang")) {
            System.out.println("院长通过---------------");
            result = invocation.proceed();
        } else {
            System.out.println("屌丝拒绝---------------");
        }
        return result;
    }
}
