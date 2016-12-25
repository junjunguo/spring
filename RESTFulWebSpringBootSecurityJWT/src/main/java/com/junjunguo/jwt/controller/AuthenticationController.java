package com.junjunguo.jwt.controller;

import com.junjunguo.jwt.security.LoginRequest;
import com.junjunguo.jwt.security.LoginResponse;
import com.junjunguo.jwt.security.TokenUtil;
import com.junjunguo.jwt.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * This file is part of RESTFulWebSpringBootSecurityJWT.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 23/12/2016.
 * <p>
 * The RestFul Authentication controller.
 */
@RestController
public class AuthenticationController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * Create authentication token response entity.
     *
     * @param authenticationRequest the authentication request //     * @param device                the device
     * @return the response entity
     * @throws AuthenticationException the authentication exception
     */
    @CrossOrigin
    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest)
            throws AuthenticationException {
        try {
            log("1 " + authenticationRequest.getEmail() + " pass " + authenticationRequest.getPassword());

            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());

            if (passwordEncoder.matches(authenticationRequest.getPassword(), userDetails.getPassword())) {
                final String token = tokenUtil.generateToken(userDetails, null);
                log("2" + token);
                return ResponseEntity.ok(new LoginResponse(token));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email or password not correct!");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Refresh and get authentication token response entity.
     *
     * @param request the request
     * @return the response entity
     */
    @CrossOrigin
    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String          token    = request.getHeader(tokenHeader);
        String          username = tokenUtil.getUsernameFromToken(token);
        UserDetailsImpl user     = (UserDetailsImpl) userDetailsService.loadUserByUsername(username);

        if (tokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = tokenUtil.refreshToken(token);
            return ResponseEntity.ok(new LoginResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    public void log(String s) {
        System.out.println(this.getClass().getSimpleName() + "................. " + s);
    }
}
