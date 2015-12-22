package com.junjunguo.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * This file is part of aop.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 22/12/15.
 */
@Configuration
// Spring’s AspectJ auto-proxying only uses @AspectJ annotations as a guide for creating proxy-based aspects.
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.junjunguo.spring")
public class ConsertConfig {
    @Bean
    public Audience audience() {
        return new Audience();
    }
}
