package com.junjunguo.restful.service;

import com.junjunguo.restful.model.User;

import java.util.List;

/**
 * This file is part of restfulservice.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 27/10/2016.
 */
public interface UserService {
    /**
     * @param email user email
     * @return User object
     */
    User findByEmail(String email);

    /**
     * @param name user name
     * @return User object
     */
    User findByName(String name);

    /**
     * @param user object
     */
    void addUser(User user);

    /**
     * @param user object
     */
    void updateUser(User user);

    /**
     * @param email user email
     */
    void deleteUserByEmail(String email);

    /**
     * @return a List of all User objects
     */
    List<User> findAllUsers();

    /**
     * @param email user email
     * @return true or false
     */
    boolean isUserExist(String email);
}
