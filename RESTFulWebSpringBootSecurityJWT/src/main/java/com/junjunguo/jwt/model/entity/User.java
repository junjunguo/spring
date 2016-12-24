package com.junjunguo.jwt.model.entity;

import com.junjunguo.jwt.model.Gender;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * The User entity: only the user self can access
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 23/12/2016.
 */
@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "EMAIL", nullable = false, length = 64)
    @Size(min = 4, max = 64)
    private String email;

    @Column(name = "USERNAME", length = 64)
    @Size(min = 1, max = 64)
    private String username;

    @Column(name = "PASSWORD", nullable = false, length = 256)
    @Size(min = 4, max = 256)
    private String password;

    @Column(name = "FIRSTNAME", length = 64)
    @Size(min = 1, max = 64)
    private String firstname;

    @Column(name = "LASTNAME", length = 64)
    @Size(min = 1, max = 64)
    private String lastname;

    @Column(name = "COUNTRY", length = 128)
    @Size(min = 2, max = 128)
    private String country;

    @Column(name = "GENDER", columnDefinition = "TINYINT")
    private Gender gender;

    @Column(name = "BIRTH")
    @Temporal(TemporalType.DATE)
    private Date birth;

    @Column(name = "REGISTEREDTIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredTime;

    @Column(name = "LASTPASSWORDRESETDATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordResetDate;

    /**
     * Instantiates a new User.
     */
    public User() {
        this.registeredTime = new Date();
    }

    /**
     * Instantiates a new User.
     *
     * @param email    the email
     * @param username the username
     * @param password the password
     */
    public User(String email, String username, String password) {
        this();
        this.email = email;
        this.username = username;
        setPassword(password);
    }

    /**
     * Instantiates a new User.
     *
     * @param email     the email
     * @param username  the username
     * @param password  the password
     * @param firstname the firstname
     * @param lastname  the lastname
     * @param country   the country
     * @param gender    the gender
     * @param birth     the birth
     */
    public User(String email, String username, String password, String firstname, String lastname, String country,
            Gender gender, Date birth) {
        this();
        this.email = email;
        this.username = username;
        setPassword(password);
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
        this.gender = gender;
        this.birth = birth;
    }

    /**
     * Gets birth.
     *
     * @return the birth
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * Sets birth.
     *
     * @param birth the birth
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
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
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password & update last password reset date.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
        this.lastPasswordResetDate = new Date();
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
     * Sets firstname.
     *
     * @param firstname the firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
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
     * Sets lastname.
     *
     * @param lastname the lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country.
     *
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets last password reset date.
     *
     * @return the last password reset date
     */
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    private void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    /**
     * Gets registered time.
     *
     * @return the registered time
     */
    public Date getRegisteredTime() {
        return registeredTime;
    }

    @Override public String toString() {
        return "User{" +
               "email='" + email + '\'' +
               ", username='" + username + '\'' +
               ", password='" + password + '\'' +
               ", firstname='" + firstname + '\'' +
               ", lastname='" + lastname + '\'' +
               ", country='" + country + '\'' +
               ", gender=" + gender +
               ", birth=" + birth +
               ", registeredTime=" + registeredTime +
               ", lastPasswordResetDate=" + lastPasswordResetDate +
               '}';
    }
}