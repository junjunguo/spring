package com.junjunguo.restful.service.serviceImpl;

import com.junjunguo.restful.model.db.User;
import com.junjunguo.restful.dao.UserDao;
import com.junjunguo.restful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * This file is part of restfulservice.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 27/10/2016.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public User findByName(String name) {
        return userDao.findByName(name);
    }

    public void addUser(User user) {
        user.setRegisteredtime(new Date(System.currentTimeMillis()));
        userDao.saveUser(user);
    }

    public void updateUser(User user) {
        User entity = userDao.findByEmail(user.getEmail());
        if (entity != null) {
            userDao.saveUser(entity);
        }
    }

    public void deleteUserByEmail(String email) {
        userDao.deleteUserByEmail(email);
    }

    public boolean isUserExist(String email) {
        return findByEmail(email) != null;
    }
}
