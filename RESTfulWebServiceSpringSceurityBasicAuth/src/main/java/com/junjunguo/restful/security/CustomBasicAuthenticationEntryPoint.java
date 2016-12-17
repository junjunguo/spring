package com.junjunguo.restful.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This file is part of RESTfulWebServiceSpringSecurity.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 18/12/2016.
 * <p>
 * when authentication fails {@link BasicAuthenticationEntryPoint} will be triggered: spring security default will
 * redirect to a login page, which is not suitable for a rest api.
 */
public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final AuthenticationException authException)
            throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 : " + authException.getMessage());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("MY_APP_REALM");
        super.afterPropertiesSet();
    }
}
