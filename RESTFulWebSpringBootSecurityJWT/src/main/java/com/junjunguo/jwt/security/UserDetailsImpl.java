package com.junjunguo.jwt.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.junjunguo.jwt.model.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * This class is an implementation of {@link UserDetails} use for authentication.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 23/12/2016.
 */
public class UserDetailsImpl implements UserDetails {

    private final String username;
    private final String nickname;
    private final String password;
    private final String firstname;
    private final String lastname;
    private final Date   lastPasswordResetDate;

    /**
     * Instantiates a new Jwt user.
     *
     * @param username              the username = nickname
     * @param firstname             the firstname
     * @param lastname              the lastname
     * @param nickname              the nickname = username
     * @param password              the password
     * @param lastPasswordResetDate the last password reset date
     */
    public UserDetailsImpl(
            String username,
            String firstname,
            String lastname,
            String nickname,
            String password,
            Date lastPasswordResetDate
                          ) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.password = password;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    /**
     * Instantiates a new Jwt user.
     *
     * @param user the user
     */
    public UserDetailsImpl(User user) {
        this.username = user.getEmail();
        this.nickname = user.getUsername();
        this.password = user.getPassword();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.lastPasswordResetDate = user.getLastPasswordResetDate();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override public boolean isEnabled() {
        return true;
    }

    /**
     * Gets firstname.
     *
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Gets lastname.
     *
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Gets nickname.
     *
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    @Override public Collection<? extends GrantedAuthority> getAuthorities() {
        //        new SimpleGrantedAuthority(

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(AuthorityName.ROLE_USER.name()));
        return authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }


    /**
     * Gets last password reset date.
     *
     * @return the last password reset date
     */
    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}
