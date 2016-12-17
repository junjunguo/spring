package com.junjunguo.restful.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * This file is part of RESTfulWebServiceSpringSecurity.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 11/12/2016.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static String REALM = "MY_APP_REALM";

    /**
     * This section defines the user accounts which can be used for authentication as well as the roles each user has.
     */
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("junjun").password("junjun").roles("USER")
            .and()
            .withUser("guo").password("guo").roles("USER", "ADMIN");
    }

    /**
     * This section defines the security policy for the app. - BASIC authentication is supported (enough for this
     * REST-based demo) - /user is secured using URL security shown below - CSRF headers are disabled since we are only
     * testing the REST interface, not a web one.
     * <p>
     * NOTE: GET is not shown which defaults to permitted.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/user/**").hasRole("ADMIN")
            .and().httpBasic().realmName(REALM).authenticationEntryPoint(new CustomBasicAuthenticationEntryPoint());
        //        http.httpBasic().and()
        //            .authorizeRequests()
        //            .antMatchers(HttpMethod.GET, "/user").hasRole("USER")
        //            .antMatchers(HttpMethod.POST, "/user").hasRole("USER")
        //            .antMatchers(HttpMethod.PUT, "/user/**").hasRole("USER")
        //            .antMatchers(HttpMethod.PATCH, "/user/**").hasRole("USER").and()
        //            .csrf().disable(); //Cross-Site Request Forgery
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
}
