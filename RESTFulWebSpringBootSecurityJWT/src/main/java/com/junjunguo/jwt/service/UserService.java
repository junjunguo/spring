package com.junjunguo.jwt.service;


import com.junjunguo.jwt.model.entity.User;

import java.util.List;

/**
 * The interface User service.
 */
public interface UserService {
    /**
     * Find by email user.
     *
     * @param email the email
     * @return the user
     */
    User findByEmail(String email);

    /**
     * Find by name list.
     *
     * @param name the name
     * @return the list
     */
    List<User> findByName(String name);

    /**
     * Create.
     *
     * @param user the user
     */
    void create(User user);

    /**
     * Update user.
     *
     * @param user the user
     * @return the user
     */
    User update(User user);

    /**
     * Delete by email.
     *
     * @param email the email
     */
    void deleteByEmail(String email);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<User> findAll();

    /**
     * Is exist boolean.
     *
     * @param email the email
     * @return the boolean
     */
    boolean isExist(String email);
}
