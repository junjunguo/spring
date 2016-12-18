package com.junjunguo.restful.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * This file is part of restfulwebservice.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 27/10/2016.
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // AppConfiguration defines beans that would be in root-context.xml
        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // AppConfiguration defines beans that would be in server-servlet.xml
        return new Class[]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        Filter[] appFilter = {new SecurityFilter()};
        return appFilter;
    }

    //    @Override
    //    public void customizeRegistration(ServletRegistration.Dynamic registration) {
    //        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
    //    }
}