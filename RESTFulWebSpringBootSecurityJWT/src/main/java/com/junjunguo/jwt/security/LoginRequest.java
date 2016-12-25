package com.junjunguo.jwt.security;

/**
 * The User Login request model.
 */
public class LoginRequest {

//    private static final long serialVersionUID = -8445943548965154778L;

    private String email;
    private String password;

    /**
     * Instantiates a new Login request.
     */
    public LoginRequest() {
        super();
    }

    /**
     * Instantiates a new Login request.
     *
     * @param email    the email
     * @param password the password
     */
    public LoginRequest(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
