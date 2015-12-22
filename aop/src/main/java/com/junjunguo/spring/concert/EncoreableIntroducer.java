package com.junjunguo.spring.concert;

/**
 * This file is part of aop.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 22/12/15.
 */

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableIntroducer {
    @DeclareParents(value = "concert.Performance+",
                    defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
