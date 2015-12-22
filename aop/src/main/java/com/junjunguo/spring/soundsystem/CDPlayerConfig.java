package com.junjunguo.spring.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This file is part of wiring_beans.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 20/12/15.
 * <p/>
 * With no further configuration, @ComponentScan will default to scanning the same package as the configuration class.
 * Therefore, because CDPlayerConfig is in the soundsystem package, Spring will scan that package and any subpackages
 * underneath it, looking for classes that are annotated with @Component. It should find the Compact- Disc class and
 * automatically create a bean for it in Spring.
 */
@Configuration
@ComponentScan
public class CDPlayerConfig {
}


//    turn on component scanning via XML configuration:

//    <?xml version="1.0" encoding="UTF-8"?>
//<beans xmlns="http://www.springframework.org/schema/beans"
//        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
//        xmlns:context="http://www.springframework.org/schema/context"
//        xsi:schemaLocation="http://www.springframework.org/schema/beans
//        http://www.springframework.org/schema/beans/spring-beans.xsd
//        http://www.springframework.org/schema/context
//        http://www.springframework.org/schema/context/spring-context.xsd">
//<context:component-scan base-package="soundsystem" />
//</beans>