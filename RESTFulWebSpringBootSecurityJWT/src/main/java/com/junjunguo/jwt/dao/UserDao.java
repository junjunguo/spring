package com.junjunguo.jwt.dao;


import com.junjunguo.jwt.model.entity.User;

import java.util.List;

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
    List<User> findByName(String name);

    /**
     * @param user object: create a new user
     */
    void create(User user);

    /**
     * @param user object: update this user
     */
    User update(User user);

    /**
     * @param email delete user by the given email
     */
    void deleteByEmail(String email);

    /**
     * @return a List of users
     */
    List findAll();
}
