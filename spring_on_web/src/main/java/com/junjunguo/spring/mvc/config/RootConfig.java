package com.junjunguo.spring.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * This file is part of spring_on_web.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 23/12/15.
 */
@Configuration
@ComponentScan(basePackages = {"com.junjunguo.spring.mvc"},
               excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
                                                       value = EnableWebMvc.class)})
public class RootConfig {
}
