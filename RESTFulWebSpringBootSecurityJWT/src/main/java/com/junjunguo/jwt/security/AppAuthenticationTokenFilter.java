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
        String authToken = request.getHeader(this.tokenHeader);
//        authToken.startsWith("Bearer ");
        // String authToken = header.substring(7);
        String username = tokenUtil.getUsernameFromToken(authToken);

        logger.info("checking authentication for user " + username);

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // not necessary to load the use details from the database.
            // can store the information in the token.
            UserDetails userDetails = new UserDetailsImpl(userService.findByEmail(username));

            if (tokenUtil.validateToken(authToken, userDetails)) {

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                logger.info("authenticated user " + username + ", setting security context");

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        chain.doFilter(request, response);
    }
}