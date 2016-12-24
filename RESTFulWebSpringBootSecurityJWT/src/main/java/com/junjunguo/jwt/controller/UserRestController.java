package com.junjunguo.jwt.controller;

import com.junjunguo.jwt.security.TokenUtil;
import com.junjunguo.jwt.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public UserDetailsImpl getAuthenticatedUser(HttpServletRequest request) {
        String          token    = request.getHeader(tokenHeader);
        String          username = tokenUtil.getUsernameFromToken(token);
        UserDetailsImpl user     = (UserDetailsImpl) userDetailsService.loadUserByUsername(username);
        return user;
    }

}
