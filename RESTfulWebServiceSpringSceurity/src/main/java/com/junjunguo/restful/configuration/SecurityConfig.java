package com.junjunguo.restful.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * This file is part of RESTfulWebServiceSpringSecurity.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 11/12/2016.
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user").password("password").roles("USER").and().withUser("admin").password("password").roles(
                "USER", "ADMIN");
    }
}
