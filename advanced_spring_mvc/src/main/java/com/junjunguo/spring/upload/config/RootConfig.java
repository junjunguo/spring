package com.junjunguo.spring.upload.config;

import com.junjunguo.spring.upload.config.RootConfig.WebPackage;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import java.util.regex.Pattern;

@Configuration
@Import(DataConfig.class)
@ComponentScan(basePackages = {"com.junjunguo.spring.upload"},
               excludeFilters = {
                       @Filter(type = FilterType.CUSTOM,
                               value = WebPackage.class)
               })
public class RootConfig {
    public static class WebPackage extends RegexPatternTypeFilter {
        public WebPackage() {
            super(Pattern.compile("com.junjunguo.spring.upload\\.controller"));
        }
    }
}
