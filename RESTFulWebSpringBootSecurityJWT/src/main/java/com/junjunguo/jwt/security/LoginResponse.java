package com.junjunguo.jwt.security;

import java.io.Serializable;

/**
 * The Authentication response.
 */
public class LoginResponse implements Serializable {

//    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    /**
     * Instantiates a new Jwt authentication response.
     *
     * @param token the token
     */
    public LoginResponse(String token) {
        this.token = token;
    }

    /**
     * Gets token.
     *
     * @return the token
     */
    public String getToken() {
        return this.token;
    }
}
