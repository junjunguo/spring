package com.junjunguo.restful.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * This file is part of restfulwebservice.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 27/10/2016.
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        // AppConfiguration defines beans that would be in root-context.xml
        return new Class[]{AppConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // AppConfiguration defines beans that would be in server-servlet.xml
        return new Class[]{AppConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //    @Override
    //    public void customizeRegistration(ServletRegistration.Dynamic registration) {
    //        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
    //    }
}