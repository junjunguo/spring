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
     * Create and save new user in DB.
     * <p>
     * plaintext password will be encoded with {@link org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder}
     *
     * @param user the user
     * @return the user
     */
    User create(User user);

    /**
     * Update user.
     *
     * @param current the current user
     * @param update  the user with updated info.
     * @return the user
     */
    User update(User current, User update);

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

    /**
     * Change password.
     *
     * @param user        the current user
     * @param newPassword the new password
     */
    void changePassword(User user, String newPassword);
}
