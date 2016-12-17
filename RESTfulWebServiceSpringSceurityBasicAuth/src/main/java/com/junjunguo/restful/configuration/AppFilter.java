package com.junjunguo.restful.configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This file is part of RESTfulWebServiceSpringSecurity.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 18/12/2016.
 */
public class AppFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Filtering on...........................................................");
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers",
                "X-Requested-With, Content-Type, Authorization, Origin, Accept, Access-Control-Request-Method, " +
                "Access-Control-Request-Headers");
        chain.doFilter(req, res);
    }

    public void destroy() {

    }
}
