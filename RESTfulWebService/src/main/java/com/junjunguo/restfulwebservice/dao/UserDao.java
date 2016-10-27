package com.junjunguo.restfulwebservice.dao;

import com.junjunguo.restfulwebservice.model.User;

import java.util.List;

/**
 * This file is part of restfulwebservice.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 27/10/2016.
 */

public interface UserDao {
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
     * @param user object: save or update this user
     */
    void saveUser(User user);

    /**
     * @param email delete user by the given email
     */
    void deleteUserByEmail(String email);

    /**
     * @return a List of users
     */
    List<User> findAllUsers();
}
