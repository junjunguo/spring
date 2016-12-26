package com.junjunguo.jwt.security;

import com.junjunguo.jwt.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * App authentication token filter.
 */
public class AppAuthenticationTokenFilter extends OncePerRequestFilter {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private TokenUtil tokenUtil;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws
            ServletException, IOException {
        log("1 URI: " + request.getRequestURI() + " C path " + request.getContextPath());
        try {
            log(" header name "+request.getHeaderNames().nextElement());
            log(" header method "+request.getMethod());
            log(" header path info "+request.getPathInfo());
            log(" header scheme "+request.getScheme());
            log(" header auth que  "+request.getQueryString());
            String authToken = request.getHeader(this.tokenHeader);
            if (authToken != null) {

                log("2 auth " + authToken);

                if (authToken.startsWith("Bearer ")) {
                    authToken = authToken.substring(7);
                }
                String username = tokenUtil.getUsernameFromToken(authToken);

                if (username != null) {

                    // not necessary to load the use details from the database.
                    // can store the information in the token.
                    UserDetails userDetails = new UserDetailsImpl(userService.findByEmail(username));
                    log("3 user details " + userDetails + ", setting security context");

                    if (tokenUtil.validateToken(authToken, userDetails)) {

                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());

                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                        log("4 authentication: " + authentication);

                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }

            log("5 checking authentication for user " + request.getQueryString() + " response: " + response.toString());
            chain.doFilter(request, response);
        } catch (Exception e) {
            log("6 exception " + e.getMessage());
        }
    }

    public void log(String s) {
        System.out.println(this.getClass().getSimpleName() + "................. " + s);
    }
}