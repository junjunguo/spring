package com.junjunguo.spring.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import com.junjunguo.spring.mvc.config.RootConfig.WebPackage;

import java.util.regex.Pattern;

@Configuration
@Import(DataConfig.class)
@ComponentScan(basePackages = {"com.junjunguo.spring.mvc"},
               excludeFilters = {
                       @Filter(type = FilterType.CUSTOM,
                               value = WebPackage.class)
               })
public class RootConfig {
    public static class WebPackage extends RegexPatternTypeFilter {
        public WebPackage() {
            super(Pattern.compile("com.junjunguo.spring.mvc\\.web"));
        }
    }
}
