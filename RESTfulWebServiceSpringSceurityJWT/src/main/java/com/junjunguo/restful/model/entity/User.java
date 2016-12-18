package com.junjunguo.restful.model.entity;

import com.junjunguo.restful.model.Gender;
import com.junjunguo.restful.util.MyDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;
import java.util.Date;

/**
 * This file is part of restfulservice.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 27/10/2016.
 */
@Entity
@Table(name = "USER")
public class User {
    @Column(name = "NAME", nullable = false, columnDefinition = "VARCHAR(64)")
    private String name;
    @Id
    @Column(name = "EMAIL", nullable = false, columnDefinition = "VARCHAR(64)")
    private String email;
    @Column(name = "PASSWORD", nullable = false, columnDefinition = "VARCHAR(128)")
    private String password;
    @Column(name = "PASSWORDRESETDATE", nullable = false, columnDefinition = "DATETIME")
    private Date   lastPasswordResetDate;
    @Column(name = "COUNTRY", nullable = true, columnDefinition = "VARCHAR(64)")
    private String country;
    @Column(name = "GENDER", nullable = true, columnDefinition = "TINYINT")
    private Gender gender;
    @Column(name = "BIRTH", nullable = true, columnDefinition = "DATE")
    private Date   birth;
    @Column(name = "REGISTEREDTIME", nullable = false, columnDefinition = "DATETIME")
    private Date   registeredTime;

    /**
     * Instantiates a new User.
     *
     * @param name     user name
     * @param email    user email
     * @param password user password
     */
    public User(String name, String email, String password) {
        this(name, email, password, "", Gender.Unknown, null);
    }

    /**
     * @param name     user name
     * @param email    user email
     * @param password user password
     * @param country  user come from
     * @param gender   user gender MALE,FEMALE
     * @param birth    user birthday
     */
    public User(String name, String email, String password, String country, Gender gender, Date birth) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.lastPasswordResetDate = Calendar.getInstance().getTime();
        this.country = country;
        this.gender = gender;
        this.birth = birth;
        this.registeredTime = Calendar.getInstance().getTime();
    }

    /**
     * JsonMappingException: No suitable constructor found for type. Jackson can’t access the constructor.
     */
    public User() {
        super();
    }

    /**
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new registeredTime.
     *
     * @param registeredTime New value of registeredTime.
     */
    public void setRegisteredtime(Date registeredTime) {
        this.registeredTime = registeredTime;
    }

    /**
     * Sets new email.
     *
     * @param email New value of email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets new password.
     *
     * @param password New value of password.
     */
    public void setPassword(String password) {
        this.password = password;
        this.lastPasswordResetDate = Calendar.getInstance().getTime();
    }

    /**
     * Sets last password reset date.
     *
     * @param lastPasswordResetDate the last password reset date
     */
    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    /**
     * Sets new birth.
     *
     * @param birth New value of birth.
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * Gets email.
     *
     * @return Value of email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets password.
     *
     * @return Value of password.
     */
    public String getPassword() {
        return password;
    }


    /**
     * Gets last password reset date.
     *
     * @return the last password reset date
     */
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    /**
     * Sets new country.
     *
     * @param country New value of country.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets country.
     *
     * @return Value of country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets new gender.
     *
     * @param gender New value of gender.
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Gets gender.
     *
     * @return Value of gender.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Gets birth.
     *
     * @return Value of birth.
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * Sets new name.
     *
     * @param name New value of name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets registeredTime.
     *
     * @return Value of registeredTime.
     */
    public Date getRegisteredtime() {
        return registeredTime;
    }

    @Override
    public String toString() {
        return "User [name=" + name +
               ", email='" + email +
               ", country='" + country +
               ", gender='" + gender +
               ", password='" + password +
               ", birth=" + new MyDate().getDateString(birth) +
               ", registeredTime=" + new MyDate().getDateString(registeredTime) +
               ']';
    }

}
