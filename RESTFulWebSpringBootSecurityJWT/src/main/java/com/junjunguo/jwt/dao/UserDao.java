package com.junjunguo.jwt.dao;


import com.junjunguo.jwt.model.entity.User;

import java.util.List;

/**
 * The interface User dao.
 */
public interface UserDao {
    /**
     * Find by email user.
     *
     * @param email user email
     * @return User object
     */
    User findByEmail(String email);

    /**
     * Find by name list.
     *
     * @param name user name
     * @return User object
     */
    List<User> findByName(String name);

    /**
     * Create user.
     *
     * @param user object: create a new user
     * @return the user
     */
    User create(User user);

    /**
     * Update user.
     *
     * @param user object: update this user
     * @return the user
     */
    User update(User user);

    /**
     * Delete by email.
     *
     * @param email delete user by the given email
     */
    void deleteByEmail(String email);

    /**
     * Find all list.
     *
     * @return a List of users
     */
    List findAll();
}
