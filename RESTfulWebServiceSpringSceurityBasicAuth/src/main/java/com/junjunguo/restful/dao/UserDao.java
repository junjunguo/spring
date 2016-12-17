package com.junjunguo.restful.dao;

import com.junjunguo.restful.model.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * This file is part of restfulservice.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 27/10/2016.
 */
@PreAuthorize("hasRole('ROLE_USER')")
//public interface UserDao extends CrudRepository<User, String> {
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
     * @param user object: save this user
     */
    void saveUser(User user);

    /**
     * @param user object: update this user
     */
    void updateUser(User user);

    /**
     * @param email delete user by the given email
     */
    void deleteUserByEmail(String email);

    /**
     * @return a List of users
     */
    List findAllUsers();
}
